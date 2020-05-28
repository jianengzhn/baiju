package com.eppear.baiju.config.filter;

import com.eppear.baiju.common.framework.utils.StrUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 后台应用过滤器，用于打印请求性能信息
 * @author zhangjf
 * @date 2020-05-26 22:05:01
 */
@Component
@Slf4j
@WebFilter(filterName = "AppFilter", urlPatterns = "/**")
public class AppFilter implements Filter {

    private static final String UNKNOWN_IP = "unknown";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 请求进入时间
        long start = System.currentTimeMillis();
        log.info("-->收到客户端请求[{}]", getIp(request));
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("<--完成客户端请求[{}],用时[{}]毫秒", getIp(request),System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {

    }

    /**
     * 获取IP地址
     *
     * @param request 请求
     * @return request发起客户端的IP地址
     */
    private String getIp(HttpServletRequest request) {
        if (request == null) {
            return "0.0.0.0";
        }

        String xip = request.getHeader("X-Real-IP");
        String xFor = request.getHeader("X-Forwarded-For");


        if (StrUtils.isNotEmpty(xFor) && !UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xFor.indexOf(",");
            if (index != -1) {
                return xFor.substring(0, index);
            } else {
                return xFor;
            }
        }
        String a = StrUtils.toCamelCase("dadfas");
        xFor = xip;
        if (StrUtils.isNotEmpty(xFor) && !UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            return xFor;
        }

        if (StrUtils.isBlank(xFor) || UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("Proxy-Client-IP");
        }
        if (StrUtils.isBlank(xFor) || UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StrUtils.isBlank(xFor) || UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StrUtils.isBlank(xFor) || UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StrUtils.isBlank(xFor) || UNKNOWN_IP.equalsIgnoreCase(xFor)) {
            xFor = request.getRemoteAddr();
        }
        return xFor;
    }
}
