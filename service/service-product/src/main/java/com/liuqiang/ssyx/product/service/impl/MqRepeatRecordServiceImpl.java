package com.liuqiang.ssyx.product.service.impl;

import com.liuqiang.ssyx.product.entity.MqRepeatRecord;
import com.liuqiang.ssyx.product.mapper.MqRepeatRecordMapper;
import com.liuqiang.ssyx.product.service.MqRepeatRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * mq去重表 服务实现类
 * </p>
 *
 * @author liuqiang132
 * @since 2023-09-05
 */
@Service
public class MqRepeatRecordServiceImpl extends ServiceImpl<MqRepeatRecordMapper, MqRepeatRecord> implements MqRepeatRecordService {

}
