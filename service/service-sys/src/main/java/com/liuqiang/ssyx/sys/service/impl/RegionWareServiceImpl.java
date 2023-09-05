package com.liuqiang.ssyx.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.ssyx.common.exception.SSyxException;
import com.liuqiang.ssyx.common.result.ResultCodeEnum;
import com.liuqiang.ssyx.model.sys.RegionWare;
import com.liuqiang.ssyx.sys.mapper.RegionWareMapper;
import com.liuqiang.ssyx.sys.service.RegionWareService;
import com.liuqiang.ssyx.vo.sys.RegionWareQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 城市仓库关联表 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare> implements RegionWareService {
    @Autowired
    private RegionWareMapper regionWareMapper;


    //取消开通区域
    @Override
    public void qxUpdateStatus(Long id, Long status) {
        RegionWare regionWare = regionWareMapper.selectById(id);
        regionWare.setStatus(status.intValue());
        regionWareMapper.updateById(regionWare);

    }

    //新增区域城市仓库
    @Override
    public void saveRegionWare(RegionWare regionWare) {
        LambdaQueryWrapper<RegionWare> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RegionWare::getRegionId,regionWare.getRegionId());
        Integer count = regionWareMapper.selectCount(wrapper);
        if (count==0){
            //抛出异常，表示该区域已经开通
            throw new SSyxException(ResultCodeEnum.REGION_OPEN);
        }
        //新增数据
        regionWareMapper.insert(regionWare);
    }



    //条件分页查询区域开通
    @Override
    public Page<RegionWare> wrapperPageSelectAll(Page<RegionWare> pages, RegionWareQueryVo regionWareQueryVo) {
        String keyword = regionWareQueryVo.getKeyword();
        LambdaQueryWrapper<RegionWare> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)){
            //根据区域名称或者仓库名称来查询
            wrapper.like(RegionWare::getRegionName,keyword).or().like(RegionWare::getWareName,keyword);
            //按创建时间倒序排序
            wrapper.orderByDesc(RegionWare::getCreateTime);
        }
        Page<RegionWare> selectPageResult = regionWareMapper.selectPage(pages, wrapper);
        return selectPageResult;
    }

}
