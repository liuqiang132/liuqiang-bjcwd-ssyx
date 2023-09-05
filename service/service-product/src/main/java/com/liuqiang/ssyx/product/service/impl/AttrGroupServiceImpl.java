package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.AttrGroup;
import com.liuqiang.ssyx.product.mapper.AttrGroupMapper;
import com.liuqiang.ssyx.product.service.AttrGroupService;
import com.liuqiang.ssyx.vo.product.AttrGroupQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 属性分组 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {

    @Autowired
    private AttrGroupMapper attrGroupMapper;
    //分页查询平台商品分组
    @Override
    public IPage<AttrGroup> getPageAttrGroup(Page<AttrGroup> attrGroupPage, AttrGroupQueryVo attrGroupQueryVo) {
        LambdaQueryWrapper<AttrGroup> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(attrGroupQueryVo.getName())){
            queryWrapper.like(AttrGroup::getName,attrGroupQueryVo.getName());
        }
        queryWrapper.orderByDesc(AttrGroup::getCreateTime);
        Page<AttrGroup> selectPage = attrGroupMapper.selectPage(attrGroupPage, queryWrapper);
        return selectPage;
    }
}
