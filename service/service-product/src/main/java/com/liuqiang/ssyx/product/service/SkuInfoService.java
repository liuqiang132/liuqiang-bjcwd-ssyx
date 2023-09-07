package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.vo.product.SkuInfoQueryVo;
import com.liuqiang.ssyx.vo.product.SkuInfoVo;

/**
 * <p>
 * sku信息 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
public interface SkuInfoService extends IService<SkuInfo> {

    //分页查询sku商品列表
    IPage<SkuInfo> getPageSkuInfoList(Page<SkuInfo> skuInfoPage, SkuInfoQueryVo skuInfoQueryVo);

    //保存sku商品
    void saveSkuInfo(SkuInfoVo skuInfoVo);

    //根据id查询sku商品列表
    SkuInfoVo getSkuInfo(Long id);

    //根据id更新sku商品列表
    void updateOrSaveSkuInfo(SkuInfoVo skuInfoVo);

    //商品上架
    void publishSkuInfo(Long id, Integer status);

    //商品审核
    void checkSkuInfo(Long id, Integer status);

    //新人专享
    void isNewPerson(Long id, Integer status);
}
