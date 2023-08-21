package com.liuqiang.ssyx.vo.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryQueryVo {
	
	@ApiModelProperty(value = "分类名称")
	private String name;

}

