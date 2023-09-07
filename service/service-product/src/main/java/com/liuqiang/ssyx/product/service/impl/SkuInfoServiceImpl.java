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



    //商品上架
    @Override
    public void publishSkuInfo(Long id, Integer status) {
        //判断商品是否审核通过
        if (status==1){
            //设置商品上架
            SkuInfo skuInfo = skuInfoMapper.selectById(id);
            skuInfo.setPublishStatus(status);
            skuInfoMapper.updateById(skuInfo);
            //TODO 值mq把数据同步到es中
        }else {
            //设置商品下架
            SkuInfo skuInfo = skuInfoMapper.selectById(id);
            skuInfo.setPublishStatus(status);
            skuInfoMapper.updateById(skuInfo);
            //TODO 值mq把数据同步到es中
        }
    }

    //商品审核
    @Override
    public void checkSkuInfo(Long id, Integer status) {
        //判断商品是否审核通过
        if (status==1){
            //设置商品审核通过
            SkuInfo skuInfo = skuInfoMapper.selectById(id);
            skuInfo.setCheckStatus(status);
            skuInfoMapper.updateById(skuInfo);
        }else {
            //设置商品审核不通过
            SkuInfo skuInfo = skuInfoMapper.selectById(id);
            skuInfo.setCheckStatus(status);
            skuInfoMapper.updateById(skuInfo);
        }

    }

    //新人专享
    @Override
    public void isNewPerson(Long id, Integer status) {
        SkuInfo skuInfo = skuInfoMapper.selectById(id);
        skuInfo.setIsNewPerson(status);
        skuInfoMapper.updateById(skuInfo);


    }
    //根据id更新sku商品列表
    @Override
    public void updateOrSaveSkuInfo(SkuInfoVo skuInfoVo) {
        /**
         * 1.修改sku的基本信息
         * 2.先删除再修改sku的图片信息
         * 3.先删除再修改sku的海报信息
         * 4.先删除再修改sku的属性信息
         * 5.更新全部数据
         */
        Long skuInfoVoId = skuInfoVo.getId();
        if (!StringUtils.isEmpty(skuInfoVo)){
            SkuInfo skuInfo = new SkuInfo();
            BeanUtils.copyProperties(skuInfoVo,skuInfo);
            skuInfoMapper.updateById(skuInfoVo);

            skuImageService.remove(new LambdaQueryWrapper<SkuImage>().eq(SkuImage::getSkuId,skuInfoVo.getId()));
            List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
            if (!CollectionUtils.isEmpty(skuImagesList)){
                for (SkuImage skuImage : skuImagesList) {
                    skuImage.setSkuId(skuInfoVoId);
                }
                skuImageService.saveBatch(skuImagesList);
            }

            skuPosterService.remove(new LambdaQueryWrapper<SkuPoster>().eq(SkuPoster::getSkuId,skuInfoVo.getId()));
            List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
            if (!CollectionUtils.isEmpty(skuPosterList)){
                for (SkuPoster skuPoster : skuPosterList) {
                    skuPoster.setSkuId(skuInfoVoId);
                }
                skuPosterService.saveBatch(skuPosterList);
            }



            skuAttrValueService.remove(new LambdaQueryWrapper<SkuAttrValue>().eq(SkuAttrValue::getSkuId,skuInfoVo.getId()));
            List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
            if (!CollectionUtils.isEmpty(skuAttrValueList)){
                for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                    skuAttrValue.setSkuId(skuInfoVoId);
                }
                skuAttrValueService.saveBatch(skuAttrValueList);
            }

        }
    }

    //根据id查询sku商品列表
    @Override
    public SkuInfoVo getSkuInfo(Long id) {
        /**
         * 1.根据id查询sku基本信息
         * 2.根据id查询商品图片列表
         * 3.根据id查询商品海报列表
         * 4.根据id查询商品属性信息列表
         * 5.封装所有数据，并返回
         */
        SkuInfoVo skuInfoVo = new SkuInfoVo();
        SkuInfo skuInfo = skuInfoMapper.selectById(id);
        List<SkuImage> skuImageList = skuImageService.getImageListBySkuId(id);
        List<SkuPoster>  skuPosterList=skuPosterService.getPosterListBySkuId(id);
        List<SkuAttrValue>  skuAttrValueList = skuAttrValueService.getAttrValueBySkuId(id);

        //封装所有数据，并返回
        BeanUtils.copyProperties(skuInfo,skuInfoVo);
        skuInfoVo.setSkuImagesList(skuImageList);
        skuInfoVo.setSkuPosterList(skuPosterList);
        skuInfoVo.setSkuAttrValueList(skuAttrValueList);
        return skuInfoVo;
    }



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
        BeanUtils.copyProperties(skuInfoVo,skuInfo);//将skuInfoVo中skuInfo存在的属性复制到skuInfo中
        skuInfoMapper.insert(skuInfo);

        Long skuInfoVoId = skuInfoVo.getId();
        //2.保存商品海报信息
        List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
        if (!CollectionUtils.isEmpty(skuPosterList)){
            for (SkuPoster skuPoster : skuPosterList) {
                skuPoster.setSkuId(skuInfoVoId);
            }
            skuPosterService.saveBatch(skuPosterList);
        }
        //3.保存商品图片信息
        List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
        if (!CollectionUtils.isEmpty(skuImagesList)){
            for (SkuImage skuImage : skuImagesList) {
                skuImage.setSkuId(skuInfoVoId);
            }
            skuImageService.saveBatch(skuImagesList);
        }
        //4.保存平台属性信息
        List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        if (!CollectionUtils.isEmpty(skuAttrValueList)){
            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                skuAttrValue.setSkuId(skuInfoVoId);
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
