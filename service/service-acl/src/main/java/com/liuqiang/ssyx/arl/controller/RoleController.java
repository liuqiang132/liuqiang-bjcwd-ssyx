package com.liuqiang.ssyx.arl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuqiang.ssyx.arl.service.RoleService;
import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.acl.Role;
import com.liuqiang.ssyx.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 角色接口
 * @date 2023/8/21 19:57
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色分页列表(带搜索)")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, RoleQueryVo roleQueryVo) {
        Page<Role> page1 = new Page<>(page, limit);
        IPage<Role> pageResult = roleService.pageRoleList(page1, roleQueryVo);
        return Result.success(pageResult);
    }

    @ApiOperation(value = "保存一个新角色")
    @PostMapping("/save")
    public Result saveRole(@RequestBody Role role) {
        boolean save = roleService.save(role);
        if (save){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "获取某个角色")
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        Role role = roleService.getById(id);
        return Result.success(role);

    }

    @ApiOperation(value = "更新一个角色")
    @PutMapping("/update")
    public Result updateById(@RequestBody Role role) {
        QueryWrapper<Role> updateRole = new QueryWrapper<>();
        updateRole.eq("id", role.getId());
        boolean update = roleService.update(role, updateRole);
        if (update){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "获取一个角色的所有权限列表")
    @GetMapping("/toAssign/{roleId}")
    public Result updateById(@PathVariable("roleId") Integer roleId) {
        //TODO
        return Result.success(null);

    }

    @ApiOperation(value = "删除某个角色")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Integer id) {
        boolean removeById = roleService.removeById(id);
        if (removeById){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }

    @ApiOperation(value = "批量删除多个角色")
    @DeleteMapping("/batchRemove")
    public Result removeRoles(@RequestBody List<Long> ids) {
        boolean removeByIds = roleService.removeByIds(ids);
        if (removeByIds){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }
}
