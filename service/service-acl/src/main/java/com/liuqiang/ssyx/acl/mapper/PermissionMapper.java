package com.liuqiang.ssyx.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.ssyx.model.acl.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author liuqiang132
 * @since 2023-08-27
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
