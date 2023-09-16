package com.liuqiang.ssyx.search.controller;

import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 商品搜索列表接口
 * @date 2023/9/14 12:19
 */
@RestController
@RequestMapping("/api/search/sku")
public class SkuApiController {

    @Autowired
    private SkuService skuService;
    //商品上架
    @GetMapping("/inner/upperSku/{skuId}")
    public Result upperSku(@PathVariable("skuId") Long skuId){
        skuService.upperSku(skuId);
        return Result.success(null);
    }


    //商品下架
    @GetMapping("/inner/lowerSku/{skuId}")
    public Result lowerSku(@PathVariable("skuId") Long skuId){
        skuService.lowerSku(skuId);
        return Result.success(null);
    }

}
