package com.liuqiang.ssyx.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2023/9/6 17:39
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun")
public class OssProperties {

    /**
     *
     */
    private String endpoint;

    /**
     *
     */
    private String keyId;
    /**
     *
     */
    private String keySecret;
    /**
     *
     */
    private String bucketName;

}
