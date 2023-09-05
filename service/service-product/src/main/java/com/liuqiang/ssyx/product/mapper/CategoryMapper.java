package com.liuqiang.ssyx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.ssyx.model.product.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
