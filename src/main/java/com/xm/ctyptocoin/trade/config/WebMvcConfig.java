package com.xm.ctyptocoin.trade.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by xxz on 2018/5/19.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/main").setViewName("main");
//        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/5xx").setViewName("error/5xx");
        registry.addViewController("/404").setViewName("error/404");
    }

//    @Bean
//    public AdminInterceptor adminInterceptor(){
//        return new AdminInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin/**");
//        super.addInterceptors(registry);
//    }
}
