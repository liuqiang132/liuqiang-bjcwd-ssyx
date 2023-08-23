package com.liuqiang.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.acl.mapper.AdminMapper;
import com.liuqiang.ssyx.acl.service.AdminService;
import com.liuqiang.ssyx.model.acl.Admin;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
