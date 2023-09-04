package com.liuqiang.ssyx.sys.controller;


import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.sys.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
@RestController
@RequestMapping("/admin/sys/region")
@Api(tags = "地区表接口")
@CrossOrigin("*")
public class RegionController {

    @Autowired
    private RegionService regionService;


    @ApiOperation(value = "根据关键字查询地区表")
    @GetMapping("/findRegionByKeyword/{keyword}")
    public Result findRegionByKeyword(@PathVariable("keyword") String keyword) {
        return Result.success(null);
    }

    @ApiOperation(value = "根据关键字查询地区表")
    @GetMapping("/findByParentId/{parentId}")
    public Result findByParentId(@PathVariable("parentId") Long parentId) {
        return Result.success(null);
    }

}

