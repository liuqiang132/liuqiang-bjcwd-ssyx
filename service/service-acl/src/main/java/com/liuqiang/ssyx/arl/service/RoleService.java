package com.liuqiang.ssyx.arl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.acl.Role;
import com.liuqiang.ssyx.vo.acl.RoleQueryVo;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 角色业务接口
 * @date 2023/8/21 19:53
 */
public interface RoleService extends IService<Role> {

    IPage<Role> pageRoleList(Page<Role> page1, RoleQueryVo roleQueryVo);
}
