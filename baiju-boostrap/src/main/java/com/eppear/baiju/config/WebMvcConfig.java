package com.eppear.baiju.config;

import com.eppear.baiju.config.interceptor.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web服务中Mvc相关配置
 * @author zhangjf
 * @date 2020-05-21 21:58:52
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册自定拦截器到系统中
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SysInterceptor());
    }
}
