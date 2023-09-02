package com.liuqiang.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.acl.mapper.PermissionMapper;
import com.liuqiang.ssyx.acl.service.PermissionService;
import com.liuqiang.ssyx.acl.utils.PermissionHandlers;
import com.liuqiang.ssyx.model.acl.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    //获取权限(菜单/功能)列表
    @Override
    public  List<Permission> queryAllMenu() {

        //查询所有的菜单列表
        List<Permission> AllPermissionList = permissionMapper.selectList(null);
        //转换为指定对的数据格式
        List<Permission> permissionsResult = PermissionHandlers.parsePermission(AllPermissionList);
        return permissionsResult;
    }

    //删除一个权限项
    @Override
    public void removeChildById(Long id) {
        //封装所有的id
        List<Long> idsList = new ArrayList<>();
        /**
         * 1.该如何得到所有的id?
         *  1.1 根据当前菜单id,获取当前菜单下面所有子菜单，如果子菜单下面还有子菜单，都要获取到
         *  重点: 递归找当前菜单子菜单
         */
        deleteAllPermissionById(id,idsList);
        //设置当前菜单id
        idsList.add(id);
        //递归删除所有的id
        int deleteResult = permissionMapper.deleteBatchIds(idsList);
    }

    //递归找当前菜单子菜单
    private void deleteAllPermissionById(Long id, List<Long> idsList) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getPid,id);
        List<Permission> permissionList = permissionMapper.selectList(wrapper);
        //处理数据
        permissionList.forEach((item)->{
            //封装数据id到idsList
            idsList.add(item.getPid());
            //递归
            deleteAllPermissionById(item.getPid(),idsList);
        });
    }
}
