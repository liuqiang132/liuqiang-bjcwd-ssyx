package com.liuqiang.ssyx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.ssyx.model.product.SkuStockHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * sku的库存历史记录 Mapper 接口
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Mapper
public interface SkuStockHistoryMapper extends BaseMapper<SkuStockHistory> {

}
