package com.lqh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyCorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration = new CorsConfiguration();  // 元对象
        configuration.addAllowedOrigin("http://localhost:7777");  // 允许哪些进行访问
        configuration.setAllowCredentials(true);  // 获取cooki
        configuration.addAllowedMethod("*");  // 允许哪些方法
        configuration.addAllowedHeader("*"); // 允许哪些请求头

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();  // 过滤资源
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);


        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
