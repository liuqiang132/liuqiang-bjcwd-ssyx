package com.liuqiang.ssyx.search.service.impl;

import com.liuqiang.ssyx.client.product.ProductFeignClient;
import com.liuqiang.ssyx.enums.SkuType;
import com.liuqiang.ssyx.model.product.Category;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.model.search.SkuEs;
import com.liuqiang.ssyx.search.mapper.SkuMapper;
import com.liuqiang.ssyx.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 商品服务类
 * @date 2023/9/14 12:23
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private ProductFeignClient productFeignClient;

    //上架商品列表
    @Override
    public void upperSku(Long skuId) {
        /**
         * 1.通过远程调用,获取skuinfo信息
         * 2.封装对象到skuEs中
         * 3.将数据同步到Es中
         */
        SkuEs skuEs = new SkuEs();
        SkuInfo skuInfo = productFeignClient.getSkuInfo(skuId);
        if (skuInfo == null){
            return;
        }
        Category category = productFeignClient.getCategory(skuInfo.getCategoryId());
        if (category!=null){
            skuEs.setCategoryId(category.getId());
            skuEs.setCategoryName(category.getName());
        }
        skuEs.setId(skuInfo.getId());
        skuEs.setKeyword(skuInfo.getSkuName()+","+skuEs.getCategoryName());
        skuEs.setWareId(skuInfo.getWareId());
        skuEs.setIsNewPerson(skuInfo.getIsNewPerson());
        skuEs.setImgUrl(skuInfo.getImgUrl());
        skuEs.setTitle(skuInfo.getSkuName());
        if (skuInfo.getSkuType()== SkuType.COMMON.getCode()){
            skuEs.setSkuType(0);
            skuEs.setPrice(skuInfo.getPrice().doubleValue());
            skuEs.setStock(skuInfo.getStock());
            skuEs.setSale(skuInfo.getSale());
            skuEs.setPerLimit(skuInfo.getPerLimit());
        }
        skuMapper.save(skuEs);
    }
    //下架商品列表
    @Override
    public void lowerSku(Long skuId) {
        //删除即可
        skuMapper.deleteById(skuId);
    }
}
