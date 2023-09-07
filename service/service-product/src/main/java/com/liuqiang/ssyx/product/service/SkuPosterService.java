package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.SkuPoster;

import java.util.List;

/**
 * <p>
 * 商品海报表 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
public interface SkuPosterService extends IService<SkuPoster> {

    //根据id查询商品海报列表
    List<SkuPoster> getPosterListBySkuId(Long id);
}
