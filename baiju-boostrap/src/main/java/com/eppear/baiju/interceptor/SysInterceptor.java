package com.eppear.baiju.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjf
 * @date 2020-05-21 22:02:47
 */
@Slf4j
public class SysInterceptor extends HandlerInterceptorAdapter {

    /**
     * 方法执行的处理过程
     * <p>本方法主要用于性能监控，参数打印，共公参与转换处理等
     *
     * @param request  请求对像
     * @param response 响应对像
     * @param handler  请求的目标方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("  当前请求的URL: {}", request.getRequestURI());
        log.info("  请求的目标方法: {}", handler);
        Map<String, ?> params = transToMap(request.getParameterMap());
        if (!params.isEmpty()) {
            log.debug("  当前请求参数打印");
            parmPrint("  参数 ", params);
        }

        // 系统开关
       /* String sysSwitch = "1";
        boolean ifWhiteList = whiteListCheck(request);
        // 系统关闭时 ，只有系统管理员能登录
        if (Constants.SYS_SWITCH_OFF.equals(sysSwitch)) {
            if (!ifWhiteList) {
                // TODO 需要后期完善系统开关的处理
            }
        }*/
        /*
        // TODO 记录当前请求的菜单项ID,为返回时做数据记录,后期有好办法时,则去掉此处理
        String currentLeafMenuId = request.getParameter(Constants.CURRENT_MENU_LEAF_ID);
        if (currentLeafMenuId != null) {
            if (!"".equals(currentLeafMenuId.trim())) {
                request.getSession().setAttribute(Constants.CURRENT_MENU_LEAF_ID, currentLeafMenuId);
            }
        }*/
        return true;
    }

    /**
     * 请求参数格式化打印
     * @param prefix
     * @param map
     */
    private void parmPrint(String prefix, Map<String, ?> map) {
        if (map != null) {
            Set<String> keys = map.keySet();
            Iterator<String> iter = keys.iterator();
            while (iter.hasNext()) {
                String name = iter.next();
                if (name.contains("org.springframework.validation.BindingResult")) {
                    continue;
                }
                String value = "";
                try {
                    value = map.get(name).toString();
                } catch (Exception e) {
                    log.error("转换参数【{}】发生异常：", name, e);
                }
                log.info("{} {}： {}", prefix, name, value);
            }
        }
    }

    /**
     * 转换请求参数格式
     * @param parameterMap 请求参数
     * @return Map格式的参数
     */
    private Map<String,String> transToMap(Map parameterMap) {

        Map<String,String> returnMap = new HashMap<>(2);
        Iterator entries = parameterMap.entrySet().iterator();
        Map.Entry entry;
        String name,value;
        while (entries.hasNext()) {
            value = "";
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
}
