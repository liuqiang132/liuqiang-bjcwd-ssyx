package com.liuqiang.ssyx.vo.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "weixinVo")
public class WeixinVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String iv;
	private String encryptedData;
	private String sessionKey;
	private String openId;

}