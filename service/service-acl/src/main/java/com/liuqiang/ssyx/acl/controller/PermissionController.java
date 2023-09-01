package com.liuqiang.ssyx.acl.controller;


import com.liuqiang.ssyx.acl.entity.Permission;
import com.liuqiang.ssyx.acl.service.PermissionService;
import com.liuqiang.ssyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-27
 */
@RestController
@Api(tags = "菜单管理")
@RequestMapping("/admin/acl/permission")
@CrossOrigin("*")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @ApiOperation(value = "获取权限(菜单/功能)列表")
    @GetMapping
    public Result getPermissionList(){
        List<Permission> list = permissionService.list();
        if (list!=null){
            return Result.success(list);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "删除一个权限项")
    @DeleteMapping("/remove/{id}")
    public Result   removePermission(@PathVariable("id") Long id){
        boolean b = permissionService.removeById(id);
        if (b){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }
    @ApiOperation(value = "保存一个权限项")
    @PostMapping("/save")
    public Result  addPermission(@RequestBody Permission permission){
        boolean save = permissionService.save(permission);
        if (save){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "更新一个权限项")
    @PutMapping("/update")
    public Result    updatePermission(@RequestBody Permission permission){
        boolean save = permissionService.save(permission);
        if (save){
            return Result.success(null);
        }else {
            return  Result.fail(null);
        }
    }

    @ApiOperation(value = "查看某个角色的权限列表")
    @GetMapping("/toAssign/{roleId}")
    public Result toAssign(@PathVariable("roleId") Long roleId){
        //TODO
        return Result.success(null);
    }

    @ApiOperation(value = "给某个角色授权")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestParam Long roleId,@RequestParam Long permissionId){
        //TODO
        return Result.success(null);

    }
}

