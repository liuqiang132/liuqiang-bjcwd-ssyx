package com.liuqiang.ssyx.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.ssyx.model.base.MqRepeatRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * mq去重表 Mapper 接口
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Mapper
public interface MqRepeatRecordMapper extends BaseMapper<MqRepeatRecord> {

}
