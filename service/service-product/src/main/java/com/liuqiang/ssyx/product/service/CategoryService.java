package com.liuqiang.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.product.Category;
import com.liuqiang.ssyx.vo.product.CategoryQueryVo;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
public interface CategoryService extends IService<Category> {

    //分页查询商品分类列表
    IPage<Category> getPageList(Page<Category> objectPage, CategoryQueryVo categoryQueryVo);
}
