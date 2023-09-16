package com.liuqiang.ssyx.search.service;

/**
 * @author liuqiang132
 * @version 1.0
 * @description:
 * @date 2023/9/14 12:22
 */
public interface SkuService {
    /**
     * 上架商品列表
     * @param skuId
     */
    void upperSku(Long skuId);

    /**
     * 下架商品列表
     * @param skuId
     */
    void lowerSku(Long skuId);
}
