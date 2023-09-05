package com.liuqiang.ssyx.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.sys.Region;

import java.util.List;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
public interface RegionService extends IService<Region> {

    //根据关键字查询地区表
    List<Region> getRegionByKeyword(String keyword);
}
