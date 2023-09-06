package com.liuqiang.ssyx.sso.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: MinioProperties属性配置类
 * @date 2023/9/5 18:25
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    /**
     * 对象存储服务的URL
     */
    private String endpoint;
    /**
     * Access key就像用户ID，可以唯一标识你的账户
     */
    private String accessKey;
    /**
     * Secret key是你账户的密码
     */
    private String secretKey;

    /**
     * 默认文件桶
     */
    private String bucket;
    /**
     * 域名
     */
    private String nginxHost;

}
