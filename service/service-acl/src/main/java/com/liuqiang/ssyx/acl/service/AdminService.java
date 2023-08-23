package com.liuqiang.ssyx.acl.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.acl.Admin;
import com.liuqiang.ssyx.vo.acl.AdminQueryVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-23
 */
public interface AdminService extends IService<Admin> {


    IPage getPageSelects(Page<Admin> adminPage, AdminQueryVo adminQueryVo);
}
