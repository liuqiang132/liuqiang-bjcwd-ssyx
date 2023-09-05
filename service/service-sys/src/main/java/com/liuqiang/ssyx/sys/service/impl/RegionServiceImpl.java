package com.liuqiang.ssyx.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.model.sys.Region;
import com.liuqiang.ssyx.sys.mapper.RegionMapper;
import com.liuqiang.ssyx.sys.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    //根据关键字查询地区表
    @Override
    public List<Region> getRegionByKeyword(String keyword) {

        LambdaQueryWrapper<Region> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Region::getName,keyword);
        List<Region> RegionList = regionMapper.selectList(wrapper);
        return RegionList;
    }
}
