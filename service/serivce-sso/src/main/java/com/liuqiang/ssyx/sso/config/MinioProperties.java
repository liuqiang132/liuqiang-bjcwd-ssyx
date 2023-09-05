package com.liuqiang.ssyx.sso.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: MinioProperties配置类
 * @date 2023/9/5 18:25
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "file.minio")
public class MinioProperties {

    private String endpoint;
    private String bucket;
    private String accessKey;
    private String secretKey;

    @Bean
    public MinioClient minioClient(){
      return   MinioClient.builder().endpoint(endpoint).credentials(accessKey,secretKey).build();
    }

}
