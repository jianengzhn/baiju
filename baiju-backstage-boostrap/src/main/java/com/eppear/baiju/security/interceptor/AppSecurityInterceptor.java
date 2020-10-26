package com.eppear.baiju.security.interceptor;

import com.eppear.baiju.security.AppFilterInvocationSecurityMetadataSource;
import com.eppear.baiju.security.handler.AppAccessDecisionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;

import javax.servlet.*;
import java.io.IOException;

/**
 * 权限拦截器，用于权限认证
 * @author zhangjf
 * @date 2020-10-07 21:11:11
 */
public class AppSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private AppFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    public void setAppAccessDecisionManager(AppAccessDecisionManager appAccessDecisionManager){
        super.setAccessDecisionManager(appAccessDecisionManager);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //TODO 在这里写拦截规则
        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
        invoke(fi);
    }

    public void invoke(FilterInvocation fi) throws IOException,ServletException {
        //fi里面有一个被拦截的url
        //里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
        //再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
        InterceptorStatusToken token = super.beforeInvocation(fi);
        fi.DummyRequest
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
}
