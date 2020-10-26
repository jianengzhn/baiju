package com.eppear.baiju.security.handler;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.eppear.baiju.common.framework.response.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出成功处理器，并且登出之后将cookie失效或删除
 *
 * @author jianf
 * @date 2020年05月28 15:40
 */
@Component
public class AppLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        JSON json = new JSONObject(Response.success());
        json.write(response.getWriter());
    }
}
