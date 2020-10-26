package com.eppear.baiju.security.handler;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.eppear.baiju.common.framework.constant.AppResultCodeEnum;
import com.eppear.baiju.common.framework.response.Response;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 应用后台登录失败后的处理器，主要用来对登录失败的场景（密码错误、账号锁定等…）
 * 做统一处理并返回给前台统一的json返回体。
 *
 * @author jianf
 * @date 2020年05月28 14:39
 */
@Component
public class AppAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        Response res = null;
        if(exception instanceof AccountExpiredException) {
            // 账号过期
            res = Response.fail(AppResultCodeEnum.USER_ACCOUNT_EXPIRED);
        }else if(exception instanceof BadCredentialsException){
            // 密码错误
            res = Response.fail(AppResultCodeEnum.USER_CREDENTIALS_ERROR);
        }else if(exception instanceof CredentialsExpiredException){
            // 密码过期
            res = Response.fail(AppResultCodeEnum.USER_CREDENTIALS_EXPIRED);
        }else if(exception instanceof DisabledException){
            // 账号不可用
            res = Response.fail(AppResultCodeEnum.USER_ACCOUNT_DISABLE);
        }else if(exception instanceof LockedException){
            // 账号锁定
            res = Response.fail(AppResultCodeEnum.USER_CREDENTIALS_ERROR);
        }else if(exception instanceof InternalAuthenticationServiceException){
            // 用户不存在
            res = Response.fail(AppResultCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }else {
            res = Response.fail();
        }

        //处理编码方式，防止中文乱码的情况
        // response.setContentType("text/json;charset=utf-8");
        // 放入response中返回给前台
        JSON json = new JSONObject(res,false);
        json.write(response.getWriter());
    }
}
