package com.liuqiang.ssyx.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.acl.Permission;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-27
 */
public interface PermissionService extends IService<Permission> {

    //获取权限(菜单/功能)列表
    List<Permission> queryAllMenu();

    //删除一个权限项
    void removeChildById(Long id);
}
