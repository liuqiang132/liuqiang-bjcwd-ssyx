package com.liuqiang.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.acl.mapper.AdminRoleMapper;
import com.liuqiang.ssyx.acl.mapper.RoleMapper;
import com.liuqiang.ssyx.acl.service.AdminRoleService;
import com.liuqiang.ssyx.acl.service.RoleService;
import com.liuqiang.ssyx.model.acl.AdminRole;
import com.liuqiang.ssyx.model.acl.Role;
import com.liuqiang.ssyx.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Autowired
    private AdminRoleService adminRoleService;
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

    //获取某个用户的所有角色,和根据用户id查询用户分配角色列表
    @Override
    public Map<String, Object> getRoleByAdminId(Long adminId) {
        //获取所有的角色
        List<Role> allRolesList = roleMapper.selectList(null);
        //根据用户id查询,用户角色关系表admin_role 查询用户角色id列表
        LambdaQueryWrapper<AdminRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdminRole::getAdminId,adminId);
        List<AdminRole> adminRoles = adminRoleMapper.selectList(wrapper);
        List<Long> roleIdList = adminRoles.stream()
                      .map(AdminRole::getRoleId) //item->item.getRoleId()
                      .collect(Collectors.toList());
        //创建新的list集合，用于存储用户配置角色
        List<Role> assignRoleList = new ArrayList<>();
        //判断所有角色里面是否包含已经分配角色id，封装到新的集合中
        for (Role role : allRolesList) {
            if (roleIdList.contains(role.getId())){
                assignRoleList.add(role);
            }

        }
        Map<String,Object> map= new HashMap<>();
        map.put("allRolesList",allRolesList);
        map.put("assignRoles",assignRoleList);
        return map;
    }

    //为用户分配角色
    @Override
    public void saveAdminRole(Long adminId, Long[] roleId) {
        //1.删除用户已经分配过的角色数据, 根据用户id删除admin_role表的豆芽数据
        LambdaQueryWrapper<AdminRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AdminRole::getAdminId,adminId);
        adminRoleMapper.delete(queryWrapper);
        //重新分配:遍历多个角色id，得到每隔角色id拿着每隔角色id + 用户id添加到用户角色表中
        List<AdminRole> list = new ArrayList<>();
        for (Long aLong : roleId) {
            AdminRole adminRole = new AdminRole();
            adminRole.setRoleId(aLong);
            adminRole.setAdminId(adminId);
            list.add(adminRole);
        }
        //保存数据
        adminRoleService.saveBatch(list);
    }
}
