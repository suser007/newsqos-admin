package com.suser.config;

import com.suser.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**** 拦截所有请求，判断是否有@LoginRequired注解 决定是否需要登录 ****/
        registry
                .addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
        /********/
    }
}
