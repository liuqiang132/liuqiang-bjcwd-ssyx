package com.liuqiang.ssyx.vo.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeckillSkuQueryVo {
	
	@ApiModelProperty(value = "秒杀活动id")
	private Long seckillId;

	@ApiModelProperty(value = "活动场次id")
	private Long seckillTimeId;

}

