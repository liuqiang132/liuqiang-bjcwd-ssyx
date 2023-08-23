package com.liuqiang.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.acl.mapper.AdminMapper;
import com.liuqiang.ssyx.acl.service.AdminService;
import com.liuqiang.ssyx.model.acl.Admin;
import com.liuqiang.ssyx.vo.acl.AdminQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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


    @Autowired
    private AdminMapper adminMapper;

    /**
     * 按用户名模糊查询,以及排序等功能
     * @param adminPage 分页对象
     * @param adminQueryVo 查询的vo
     * @return
     */
    @Override
    public IPage getPageSelects(Page<Admin> adminPage, AdminQueryVo adminQueryVo) {

        QueryWrapper<Admin> adminWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(adminQueryVo)){
            adminWrapper.like("username",adminQueryVo.getUsername());
            adminWrapper.orderByDesc("create_time");
        }
        Page<Admin> selectPage = adminMapper.selectPage(adminPage, adminWrapper);

        return selectPage;
    }
}
