package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.SkuImage;

import java.util.List;

/**
 * <p>
 * 商品图片 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
public interface SkuImageService extends IService<SkuImage> {

    //根据id查询商品图片列表
    List<SkuImage> getImageListBySkuId(Long id);
}
