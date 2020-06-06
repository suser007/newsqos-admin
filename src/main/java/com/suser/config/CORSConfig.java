package com.suser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * 解决XHR跨域请求   实际上是一个拦截器
 */
@Configuration
public class CORSConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")      /***允许所有映射**/
                        .allowedHeaders("*")                /***允许所有请求头**/
                        .allowedMethods("*")                /***允许所有请求方式**/
                        .allowedOrigins("*")                /***允许所有域名访问**/
                        .allowCredentials(true);            /***允许携带Cookie参数**/
            }
        };
    }
}
