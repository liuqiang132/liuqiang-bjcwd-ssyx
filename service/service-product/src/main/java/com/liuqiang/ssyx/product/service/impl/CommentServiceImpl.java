package com.liuqiang.ssyx.product.service.impl;

import com.liuqiang.ssyx.product.entity.Comment;
import com.liuqiang.ssyx.product.mapper.CommentMapper;
import com.liuqiang.ssyx.product.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
