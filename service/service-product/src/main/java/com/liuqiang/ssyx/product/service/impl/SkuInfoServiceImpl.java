package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.product.mapper.SkuInfoMapper;
import com.liuqiang.ssyx.product.service.SkuInfoService;
import com.liuqiang.ssyx.vo.product.SkuInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {


    @Autowired
    private SkuInfoMapper skuInfoMapper;
    //分页查询sku商品列表
    @Override
    public IPage<SkuInfo> getPageSkuInfoList(Page<SkuInfo> skuInfoPage, SkuInfoQueryVo skuInfoQueryVo) {

        LambdaQueryWrapper<SkuInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(skuInfoQueryVo.getKeyword()) || !StringUtils.isEmpty(skuInfoQueryVo.getCategoryId()) || !StringUtils.isEmpty(skuInfoQueryVo.getSkuType())){
            queryWrapper.like(SkuInfo::getSkuName,skuInfoQueryVo.getKeyword())
                    .or()
                    .like(SkuInfo::getCategoryId,skuInfoQueryVo.getCategoryId())
                    .or()
                    .like(SkuInfo::getSkuType,skuInfoQueryVo.getSkuType());
        }
        queryWrapper.orderByDesc(SkuInfo::getCreateTime);
        Page<SkuInfo> selectPage = skuInfoMapper.selectPage(skuInfoPage, queryWrapper);

        return selectPage;
    }
}
