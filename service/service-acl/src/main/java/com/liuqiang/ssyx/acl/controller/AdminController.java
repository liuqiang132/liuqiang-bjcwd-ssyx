package com.liuqiang.ssyx.acl.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuqiang.ssyx.acl.service.AdminService;
import com.liuqiang.ssyx.acl.service.RoleService;
import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.acl.Admin;
import com.liuqiang.ssyx.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-23
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/acl/user")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取某个用户的所有角色")
    @GetMapping("/toAssign/{adminId}")
    public Result getRoles(@PathVariable("adminId") Long adminId){

      Map<String,Object> map = roleService.getRoleByAdminId(adminId);
        return Result.success(map);
    }


    @ApiOperation(value = "给某个用户分配角色,'roleId的结构: 字符串, 'rId1,rId2,rId3'")
    @PostMapping("/doAssign")
    public Result assignRoles(@RequestParam Long adminId,@RequestParam Long[] roleId){

        roleService.saveAdminRole(adminId,roleId);
        return Result.success(null);
    }
    @ApiOperation(value = "获取后台用户分页列表(带搜索)")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, AdminQueryVo adminQueryVo){

        Page<Admin> adminPage = new Page<>(page, limit);
     IPage adminPageResult =  adminService.getPageSelects(adminPage,adminQueryVo);
        return Result.success(adminPageResult);
    }

    @ApiOperation(value = "根据ID获取某个后台用户")
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Long id){
        Admin admin = adminService.getById(id);
        if (null!=admin){
            return Result.success(admin);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "保存一个新的后台用户")
    @PostMapping("/save")
    public Result add(@RequestBody Admin admin){
        boolean save = adminService.save(admin);
        if (save){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }
    @ApiOperation(value = "更新一个后台用户")
    @PutMapping("/update")
    public Result update(@RequestBody Admin admin){
        boolean b = adminService.updateById(admin);
        if (b){
            return Result.success(null);
        }else{
            return Result.fail(null);
        }

    }
    @ApiOperation(value = "删除某个用户")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id){
        boolean b = adminService.removeById(id);
        if (b){
            return Result.success(null);
        }else
        {
            return Result.fail(null);
        }
    }
    @ApiOperation(value = "批量删除多个用户ids的结构: ids是包含n个id的数组")
    @DeleteMapping("/batchRemove")
    public Result removeUsers(@RequestBody List<Long> adminListIds){
        boolean removeByIds = adminService.removeByIds(adminListIds);
        if (removeByIds){
            return Result.success(null);
        }else
        {
            return Result.fail(null);
        }
    }
    //为用户分配角色

}

