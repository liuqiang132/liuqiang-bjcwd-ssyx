package com.liuqiang.ssyx.acl.utils;

import com.liuqiang.ssyx.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: permission数据格式转换工具类
 * @date 2023/9/2 13:10
 */
public class PermissionHandlers {

    public static List<Permission> parsePermission(List<Permission> permissionList){

        //封装最终数据
        List<Permission> trees = new ArrayList<>();
        //遍历所有的子菜单，得到pid=0
        for (Permission permission : permissionList) {
            if (permission.getPid()==0){
                permission.setLevel(1);
                //调用方法从第一层开始往下找
                trees.add(findChildren(permission,permissionList));
            }
        }
        return trees;
    }
    //递归查找
    private static Permission findChildren(Permission currentPermission, List<Permission> permissionList) {
        //数据的初始化
        currentPermission.setChildren(new ArrayList<>());
        for (Permission permission : permissionList) {
            //当前节点的id=pid是否一样，继续递归查找
            if (currentPermission.getId().longValue() == permission.getPid().longValue()){
                //封装数据
              permission.setLevel(currentPermission.getLevel()+1);
              //第一层下面可能为空
               if (permission.getChildren()==null){
                   permission.setChildren(new ArrayList<>());
               }
                //封装下一层数据
                currentPermission.getChildren().add(findChildren(permission,permissionList));
            }
        }
        return currentPermission;
    }
}
