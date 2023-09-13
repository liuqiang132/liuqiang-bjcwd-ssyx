package com.liuqiang.ssyx.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.product.service.SkuInfoService;
import com.liuqiang.ssyx.vo.product.SkuInfoQueryVo;
import com.liuqiang.ssyx.vo.product.SkuInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * sku信息 前端控制器
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Api(tags = "sku商品列表接口")
@RestController
@RequestMapping("/admin/product/skuInfo")
public class SkuInfoController {


    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation(value = "分页查询sku商品列表")
    @GetMapping("/{page}/{limit}")
    public Result getPageList(@PathVariable("page") Long page, @PathVariable("limit") Long limit, SkuInfoQueryVo skuInfoQueryVo) {
        Page<SkuInfo> skuInfoPage = new Page<>(page, limit);
        IPage<SkuInfo> pageSkuInfoList = skuInfoService.getPageSkuInfoList(skuInfoPage, skuInfoQueryVo);
        return Result.success(pageSkuInfoList);
    }

    @ApiOperation(value = "根据id查询sku商品列表")
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Long id) {
        SkuInfoVo skuInfoVo = skuInfoService.getSkuInfo(id);
        return Result.success(skuInfoVo);

    }

    @ApiOperation(value = "保存sku商品")
    @PostMapping("/save")
    public Result save(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.saveSkuInfo(skuInfoVo);
        return Result.success(null);


    }


    @ApiOperation(value = "根据id更新sku商品列表")
    @PutMapping("/update")
    public Result updateById(@RequestBody SkuInfoVo skuInfoVo) {
         skuInfoService.updateOrSaveSkuInfo(skuInfoVo);
        return Result.success(null);
    }

    @ApiOperation(value = "根据id删除sku商品列表")
    @DeleteMapping("/remove/{id}")
    public Result removeById(@PathVariable("id") Long id) {
        boolean removeById = skuInfoService.removeById(id);
        if (removeById){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }

    }

    @ApiOperation(value = "批量删除sku商品列表")
    @DeleteMapping("/batchRemove")
    public Result removeRows(@RequestBody List<Long> idList) {
        boolean removeByIds = skuInfoService.removeByIds(idList);
        if (removeByIds){
            return Result.success(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "商品上架")
    @GetMapping("/publish/{id}/{status}")
    public Result publish(@PathVariable("id") Long id,@PathVariable("status") Integer status){
        skuInfoService.publishSkuInfo(id,status);
        return Result.success(null);
    }

    @ApiOperation(value = "商品审核")
    @GetMapping("/check/{id}/{status}")
    public Result check(@PathVariable("id") Long id,@PathVariable("status") Integer status){
         skuInfoService.checkSkuInfo(id,status);
        return Result.success(null);
    }
    @ApiOperation(value = "新人专享")
    @GetMapping("/isNewPerson/{id}/{status}")
    public Result isNewPerson(@PathVariable("id") Long id,@PathVariable("status") Integer status){

        skuInfoService.isNewPerson(id,status);
        return Result.success(null);
    }


}

