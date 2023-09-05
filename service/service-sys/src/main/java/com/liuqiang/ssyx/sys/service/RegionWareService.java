package com.liuqiang.ssyx.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.ssyx.model.sys.RegionWare;
import com.liuqiang.ssyx.vo.sys.RegionWareQueryVo;

/**
 * <p>
 * 城市仓库关联表 服务类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-04
 */
public interface RegionWareService extends IService<RegionWare> {

    //条件分页查询
    Page wrapperPageSelectAll(Page<RegionWare> pages, RegionWareQueryVo regionWareQueryVo);

    //新增区域城市仓库
    void saveRegionWare(RegionWare regionWare);

    //取消开通区域
    void qxUpdateStatus(Long id, Long status);
}
