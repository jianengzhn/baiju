package com.eppear.baiju.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaServer
@PropertySource(value = {"classpath:eureka-application-dev.properties"})
public class BaijuEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaijuEurekaServerApplication.class, args);
    }

    /**
     * 配置微服务的权限验证
     */
    @EnableWebSecurity
    public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            super.configure(http);
        }
    }

}
