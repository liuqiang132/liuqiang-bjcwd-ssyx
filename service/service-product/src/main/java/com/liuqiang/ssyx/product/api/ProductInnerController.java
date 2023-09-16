package com.liuqiang.ssyx.product.api;

import com.liuqiang.ssyx.model.product.Category;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.product.service.CategoryService;
import com.liuqiang.ssyx.product.service.SkuInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2023/9/14 12:35
 */
@RestController
@RequestMapping("/api/product")
public class ProductInnerController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuInfoService skuInfoService;


    //根据skuId获取分类信息
    @ApiOperation(value = "根据分类id获取分类信息")
    @GetMapping("/inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return categoryService.getById(categoryId);

    }

    //根据SkuId获取sku信息
    @ApiOperation(value = "根据skuId获取sku信息")
    @GetMapping("inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId){
        return skuInfoService.getById(skuId);
    }

}
