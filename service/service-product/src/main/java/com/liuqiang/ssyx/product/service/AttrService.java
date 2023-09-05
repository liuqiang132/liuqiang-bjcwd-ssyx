package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.Attr;

import java.util.List;

/**
 * <p>
 * 商品属性 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
public interface AttrService extends IService<Attr> {

    //根据平台属性分组id查询平台属性列表
    List<Attr> getListAttrGroup(Long groupId);
}
