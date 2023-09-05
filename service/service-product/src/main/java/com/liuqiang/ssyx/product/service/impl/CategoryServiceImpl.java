package com.liuqiang.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.product.Category;
import com.liuqiang.ssyx.product.mapper.CategoryMapper;
import com.liuqiang.ssyx.product.service.CategoryService;
import com.liuqiang.ssyx.vo.product.CategoryQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;
    //分页查询商品分类列表
    @Override
    public IPage<Category> getPageList(Page<Category> objectPage, CategoryQueryVo categoryQueryVo) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(categoryQueryVo.getName())){
            wrapper.like(Category::getName,categoryQueryVo.getName());
        }
        wrapper.orderByDesc(Category::getCreateTime);
        Page<Category> selectPageResult = categoryMapper.selectPage(objectPage, wrapper);
        return selectPageResult;
    }
}
