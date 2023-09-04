package com.liuqiang.ssyx.sys.controller;


import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.sys.Region;
import com.liuqiang.ssyx.sys.service.RegionWareService;
import com.liuqiang.ssyx.vo.sys.RegionWareQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 城市仓库关联表 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
@Api(tags = "城市仓库表接口")
@CrossOrigin("*")
@RestController
@RequestMapping("/admin/sys/regionWare")
public class RegionWareController {

    @Autowired
    private RegionWareService regionWareService;

    @ApiOperation(value = "分页查询所有城市仓库")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, @RequestBody RegionWareQueryVo regionWareQueryVo) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据id查询城市仓库")
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Long id) {
        return Result.success(null);
    }

    @ApiOperation(value = "分页查询所有城市仓库")
    @PostMapping("/save")
    public Result save(@RequestBody Region region) {
        return Result.success(null);
    }

    @ApiOperation(value = "更新状态")
    @PostMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable("id") Long id, @PathVariable("status") Long status) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据id删除城市仓库")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据id批量删除城市仓库")
    @DeleteMapping("/batchRemove")
    public Result removeRows(@RequestBody List<Long> idList) {
        return Result.success(null);
    }

}

