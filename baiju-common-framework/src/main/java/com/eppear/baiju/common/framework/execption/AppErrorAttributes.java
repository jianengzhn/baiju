package com.eppear.baiju.common.framework.execption;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 统一异常消息处理
 *
 * @author jianf
 * @date 2020年05月10 23:29
 */
// @Component
public class AppErrorAttributes extends DefaultErrorAttributes {

    /**
     * 定义异常信息，取出响应码，map就是页面和json能获取的所有字段
     * @param webRequest
     * @param includeStackTrace
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","eppear");

        //我们的异常处理器携带的数据
//        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
//        map.put("ext",ext);
        return map;
    }
}
