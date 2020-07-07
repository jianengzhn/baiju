package com.eppear.baiju.config;

import com.eppear.baiju.security.AppAuthenticationFailureHandler;
import com.eppear.baiju.security.AppLogoutSuccessHandler;
import com.eppear.baiju.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.security.web.authentication.SpringSessionRememberMeServices;

/**
 * Web服务中Security服务配置
 * @author zjf
 * @date 2020-05-03 16:26:11
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppAuthenticationFailureHandler appAuthenticationFailureHandler;
    @Autowired
    private AppLogoutSuccessHandler appLogoutSuccessHandler;

    /**
     * 与springSession整合记住我功能
     * @return
     */
    @Bean
    public SpringSessionRememberMeServices rememberMeServices() {
        SpringSessionRememberMeServices rememberMeServices =
                new SpringSessionRememberMeServices();
        // optionally customize
        rememberMeServices.setAlwaysRemember(true);
        return rememberMeServices;
    }

    /**
     * 用户密码加密加官方式配置
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置认证方式等
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http相关的配置，包括登入登出、异常处理、会话管理等
        //super.configure(http);
        http.cors().and().csrf().disable();
        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and()
            .logout().
                //允许所有用户
                permitAll().
                //登出成功处理逻辑
                logoutSuccessHandler(appLogoutSuccessHandler).
                //登出之后删除cookie
                deleteCookies("JSESSIONID").
                //登入
                and()
            .formLogin().
                //允许所有用户
                permitAll().
                //登录成功处理逻辑
                //successHandler().
                //登录失败处理逻辑
                failureHandler(appAuthenticationFailureHandler)
        ;
    }

}
