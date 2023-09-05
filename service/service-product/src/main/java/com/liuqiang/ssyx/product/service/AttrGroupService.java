package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.AttrGroup;
import com.liuqiang.ssyx.vo.product.AttrGroupQueryVo;

/**
 * <p>
 * 属性分组 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
public interface AttrGroupService extends IService<AttrGroup> {

    //分页查询平台商品分组
    IPage<AttrGroup> getPageAttrGroup(Page<AttrGroup> attrGroupPage, AttrGroupQueryVo attrGroupQueryVo);
}
