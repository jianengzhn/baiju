package com.eppear.baiju.backstage.service.system.impl;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户权限认证服务
 * @author zhangjf
 * @date 2020-06-12 21:25:23
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //TODO 需要构造出 org.springframework.security.core.userdetails.User 对象并返回

        return null;
    }
}