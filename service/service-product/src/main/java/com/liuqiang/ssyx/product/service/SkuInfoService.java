package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.vo.product.SkuInfoQueryVo;

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
}
