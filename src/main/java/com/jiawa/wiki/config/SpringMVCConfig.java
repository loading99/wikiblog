package com.jiawa.wiki.config;


import com.jiawa.wiki.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Resource
    LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/test/**",
                        "/redis/**",
                        "/user/login",
                        "/user/logout/**",
                        "/category/list",
                        "/ebook/list",
                        "/ebook/search",
                        "/doc/list/**",
                        "/doc/vote/**",
                        "/doc/content/**",
                        "/ebook-snapshot/**"
                );
    }
}

