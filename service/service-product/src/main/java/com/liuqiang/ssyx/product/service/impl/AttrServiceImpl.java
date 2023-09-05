package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.Attr;
import com.liuqiang.ssyx.product.mapper.AttrMapper;
import com.liuqiang.ssyx.product.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品属性 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {

    @Autowired
    private  AttrMapper attrMapper;
    //根据平台属性分组id查询平台属性列表
    @Override
    public List<Attr> getListAttrGroup(Long groupId) {
        LambdaQueryWrapper<Attr> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Attr::getAttrGroupId,groupId);
        queryWrapper.orderByDesc(Attr::getCreateTime);
        List<Attr> attrList = attrMapper.selectList(queryWrapper);
        return attrList;
    }
}
