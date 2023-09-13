package com.liuqiang.ssyx.sys.controller;


import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.acl.Role;
import com.liuqiang.ssyx.model.sys.Ware;
import com.liuqiang.ssyx.sys.service.WareService;
import com.liuqiang.ssyx.vo.sys.RegionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 仓库表 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
@Api(tags = "仓库接口")
@RestController
@RequestMapping("/admin/sys/ware")
public class WareController {

    @Autowired
    private WareService wareService;

    @ApiOperation(value = "查询所有仓库")
    @GetMapping("/findAllList")
    public Result findAllList() {
        List<Ware> list = wareService.list();
        return Result.success(list);
    }
    @ApiOperation(value = "分页查询所有仓库")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, @RequestBody RegionVo regionVo) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据id查询仓库")
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Long id) {
        return Result.success(null);
    }


    @ApiOperation(value = "保存仓库")
    @PostMapping("/save")
    public Result save(@RequestBody Role role) {
        return Result.success(null);
    }

    @ApiOperation(value = "更新仓库")
    @PutMapping("/update")
    public Result updateById(@RequestBody Role role) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据id删除仓库")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据id批量删除仓库")
    @DeleteMapping("/batchRemove")
    public Result removeRows(@RequestBody List<Long> idList) {
        return Result.success(null);
    }

}

