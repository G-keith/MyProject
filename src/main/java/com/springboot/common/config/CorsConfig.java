package com.springboot.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域请求配置
 * @author keith
 * @date 2018-10-13
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Value("${domainName}")
    private String domainName;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/api/**")
                //设置允许跨域请求的域名
                .allowedOrigins(domainName)
                //设置请求头
                .allowedHeaders("*")
                //设置请求方式(post;get等)
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(36000);
    }

}
