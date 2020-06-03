package com.eppear.baiju.config;

import com.eppear.baiju.config.filter.AppFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

/**
 * 服务端配置类
 * @author zhangjf
 * @date 2020-05-13 23:23:03
 */
@Configuration
public class ServerConfig {

    /**
     * 配置字符集，防止服务器响应消息的中文乱码
     * @return 字符集
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    /**
     * 注册自定义过滤器到容器中
     * @return 自定义过滤器
     */
    @Bean
    public FilterRegistrationBean<AppFilter> filterRegist(){
        FilterRegistrationBean<AppFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AppFilter());
        registrationBean.setName("AppFilter");
        // 配置拦截URL，默认拦截：/ 所有请求，包括静态资源，但不拦JSP, /*会拦JSP
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
