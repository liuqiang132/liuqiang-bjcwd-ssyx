package com.liuqiang.ssyx.vo.activity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeckillQueryVo {
	
	@ApiModelProperty(value = "活动标题")
	private String title;

	@ApiModelProperty(value = "上下线状态")
	private Integer status;


}

