package com.liuqiang.ssyx.product.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: oss配置类
 * @date 2023/9/6 17:39
 */
@Configuration
public class OssConfig {

    @Autowired
    private OssProperties ossProperties;

    @Bean
    public OSSClient ossClient(){
        return  new OSSClient(ossProperties.getEndpoint(),ossProperties.getKeyId(),ossProperties.getKeySecret());
    }
}
