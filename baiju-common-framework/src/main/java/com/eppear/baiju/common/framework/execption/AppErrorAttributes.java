package com.eppear.baiju.common.framework.execption;

import com.eppear.baiju.common.framework.constant.AppResultCodeEnum;
import com.eppear.baiju.common.framework.response.Response;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * <p>统一异常消息处理</p>
 * 系统中定义了统一返实体 {@link Response},出现异常时，此类在原异常属性基础上，扩展增加了
 * 自定义属性，以保持和 {@link Response} 返回格式的统一.
 *
 * @author jianf
 * @date 2020年05月10 23:29
 */
@Component
public class AppErrorAttributes extends DefaultErrorAttributes {

    /**
     * 定义异常信息，取出响应码。
     * @param webRequest
     * @param includeStackTrace
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("parameterData", "");
        map.put("data", null);

        Throwable error = getError(webRequest);
        if (error instanceof AppException) {
            map.put("code", ((AppException) error).getCode());
            map.put("description", error.getMessage());
        } else {
            // 系统级异常
            map.put("code", AppResultCodeEnum.SYS_EXCEPTION.getCode());
            map.put("description", AppResultCodeEnum.SYS_EXCEPTION.getMessage());
        }

        return map;
    }
}
