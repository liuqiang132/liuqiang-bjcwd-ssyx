package com.liuqiang.ssyx.arl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.arl.mapper.RoleMapper;
import com.liuqiang.ssyx.arl.service.RoleService;
import com.liuqiang.ssyx.model.acl.Role;
import com.liuqiang.ssyx.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 角色业务类
 * @date 2023/8/21 19:54
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{


    @Autowired
    private RoleMapper roleMapper;
    //分页查询
    @Override
    public IPage<Role> pageRoleList(Page<Role> page1, RoleQueryVo roleQueryVo) {
        //判断
        QueryWrapper<Role> roleWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(roleQueryVo)) {
            roleWrapper.like("role_name", roleQueryVo.getRoleName());
            roleWrapper.select().orderByDesc("create_time");
        }
        Page<Role> rolePage = roleMapper.selectPage(page1, roleWrapper);
        return rolePage;
    }
}
