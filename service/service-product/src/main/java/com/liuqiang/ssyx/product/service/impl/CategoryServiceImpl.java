package com.liuqiang.ssyx.product.service.impl;

import com.liuqiang.ssyx.product.entity.Category;
import com.liuqiang.ssyx.product.mapper.CategoryMapper;
import com.liuqiang.ssyx.product.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
