package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.SkuAttrValue;
import com.liuqiang.ssyx.product.mapper.SkuAttrValueMapper;
import com.liuqiang.ssyx.product.service.SkuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * spu属性值 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class SkuAttrValueServiceImpl extends ServiceImpl<SkuAttrValueMapper, SkuAttrValue> implements SkuAttrValueService {


    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;

    //根据id查询商品属性信息列表
    @Override
    public List<SkuAttrValue> getAttrValueBySkuId(Long id) {

        List<SkuAttrValue> skuAttrValueList = skuAttrValueMapper.selectList(new LambdaQueryWrapper<SkuAttrValue>().eq(SkuAttrValue::getSkuId, id));

        return skuAttrValueList;
    }
}
