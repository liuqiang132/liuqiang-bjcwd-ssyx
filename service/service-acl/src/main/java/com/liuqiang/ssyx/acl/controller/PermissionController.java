package com.liuqiang.ssyx.acl.controller;


import com.liuqiang.ssyx.acl.service.PermissionService;
import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.acl.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-27
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/acl/permission")
@CrossOrigin("*")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @ApiOperation(value = "获取权限(菜单/功能)列表")
    @GetMapping
    public Result getPermissionList() {
        List<Permission> list = permissionService.queryAllMenu();
        return Result.success(list);
    }


    @ApiOperation(value = "递归删除一个权限项")
    @DeleteMapping("/remove/{id}")
    public Result removePermission(@PathVariable("id") Long id) {
         permissionService.removeChildById(id);
         return Result.success(null);
    }

    @ApiOperation(value = "保存一个权限项")
    @PostMapping("/save")
    public Result addPermission(@RequestBody Permission permission) {
        boolean save = permissionService.save(permission);
        if (save) {
            return Result.success(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "更新一个权限项")
    @PutMapping("/update")
    public Result updatePermission(@RequestBody Permission permission) {
        boolean save = permissionService.save(permission);
        if (save) {
            return Result.success(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "查看某个角色的权限列表")
    @GetMapping("/toAssign/{roleId}")
    public Result toAssign(@PathVariable("roleId") Long roleId) {
        Map<String,Object> permissionList = permissionService.queryAllPermission(roleId);
        return Result.success(permissionList);
    }

    @ApiOperation(value = "给某个角色授权")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestParam Long roleId, @RequestParam Long permissionId) {
        //TODO
        return Result.success(null);

    }
}

