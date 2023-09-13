package com.liuqiang.ssyx.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 跨域配置类
 * @date 2023/9/7 16:35
 */
@Configuration
public class WebCorsConfig   {

    @Bean
    public CorsWebFilter corsFilter() {
        //初始化cors配置大小
        CorsConfiguration config = new CorsConfiguration();
        //设置允许访问的头信息，*表示全部
        config.addAllowedHeader("*");
        //允许所有请求方法，访问跨域资源(GET POST等)
        config.addAllowedMethod("*");
        //设置允许哪些url访问跨域资源， *表示全部允许
        config.addAllowedOrigin("*");
        //预检请求的缓存时间（秒）即在这时间内对于系统的跨域请求不会再预检了
        config.setMaxAge(18000L);
        // 必须是reactive包下的UrlBasedCorsConfigurationSource
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
