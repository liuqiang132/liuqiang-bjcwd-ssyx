package com.liuqiang.ssyx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.ssyx.model.product.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品评价 Mapper 接口
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
