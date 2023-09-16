package com.liuqiang.ssyx.client.product;

import com.liuqiang.ssyx.model.product.Category;
import com.liuqiang.ssyx.model.product.SkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: product远程调用api
 * @date 2023/9/14 12:49
 */
@FeignClient(value = "service-product") //要调用的服务名称
public interface ProductFeignClient {

    //根据skuId获取分类信息
    @GetMapping("/api/product/inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId);

    //根据SkuId获取sku信息
    @GetMapping("/api/product/inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId);



}
