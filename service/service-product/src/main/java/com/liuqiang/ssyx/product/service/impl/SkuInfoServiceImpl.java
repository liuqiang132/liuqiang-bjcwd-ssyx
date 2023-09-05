package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.SkuAttrValue;
import com.liuqiang.ssyx.model.product.SkuImage;
import com.liuqiang.ssyx.model.product.SkuInfo;
import com.liuqiang.ssyx.model.product.SkuPoster;
import com.liuqiang.ssyx.product.mapper.SkuInfoMapper;
import com.liuqiang.ssyx.product.service.SkuAttrValueService;
import com.liuqiang.ssyx.product.service.SkuImageService;
import com.liuqiang.ssyx.product.service.SkuInfoService;
import com.liuqiang.ssyx.product.service.SkuPosterService;
import com.liuqiang.ssyx.vo.product.SkuInfoQueryVo;
import com.liuqiang.ssyx.vo.product.SkuInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

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
    //商品的基本信息
    @Autowired
    private SkuInfoMapper skuInfoMapper;
    //商品图片
    @Autowired
    private SkuImageService skuImageService;
    //商品海报
    @Autowired
    private SkuPosterService skuPosterService;

    //平台属性
    @Autowired
    private SkuAttrValueService skuAttrValueService;


    //保存sku商品
    @Override
    public void saveSkuInfo(SkuInfoVo skuInfoVo) {
        /**
         * 1.保存基本信息
         * 2.保存平台属性信息
         * 3.保存商品库存信息
         * 4.保存商品图片信息
         * 5.保存商品海报信息
         */
        //1.保存基本信息
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoVo,skuInfoVo);//将skuInfoVo中skuInfo存在的属性复制到skuInfo中
        skuInfoMapper.insert(skuInfo);

        //2.保存商品海报信息
        List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
        if (!CollectionUtils.isEmpty(skuPosterList)){
            for (SkuPoster skuPoster : skuPosterList) {
                skuPoster.setSkuId(skuInfo.getId());
            }
            skuPosterService.saveBatch(skuPosterList);
        }
        //3.保存商品图片信息
        List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
        if (!CollectionUtils.isEmpty(skuImagesList)){
            for (SkuImage skuImage : skuImagesList) {
                skuImage.setSkuId(skuInfo.getId());
            }
            skuImageService.saveBatch(skuImagesList);
        }
        //4.保存平台属性信息
        List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        if (!CollectionUtils.isEmpty(skuAttrValueList)){
            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                skuAttrValue.setSkuId(skuInfo.getId());
            }
            skuAttrValueService.saveBatch(skuAttrValueList);
        }

    }

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
