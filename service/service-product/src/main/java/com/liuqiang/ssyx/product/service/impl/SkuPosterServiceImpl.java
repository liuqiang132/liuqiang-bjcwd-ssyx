package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.SkuPoster;
import com.liuqiang.ssyx.product.mapper.SkuPosterMapper;
import com.liuqiang.ssyx.product.service.SkuPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品海报表 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class SkuPosterServiceImpl extends ServiceImpl<SkuPosterMapper, SkuPoster> implements SkuPosterService {

    @Autowired
    private SkuPosterMapper skuPosterMapper;

    //根据id查询商品海报列表
    @Override
    public List<SkuPoster> getPosterListBySkuId(Long id) {

        List<SkuPoster> skuPosterList = skuPosterMapper.selectList(new LambdaQueryWrapper<SkuPoster>().eq(SkuPoster::getSkuId, id));
        return skuPosterList;
    }
}
