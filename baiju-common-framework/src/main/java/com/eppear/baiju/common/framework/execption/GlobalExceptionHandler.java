package com.eppear.baiju.common.framework.execption;

import com.eppear.baiju.common.framework.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * 全局统一异常消息处理
 *
 * @author jianf
 * @date 2020年05月11 16:04
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends BasicErrorController {

    public GlobalExceptionHandler(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    /**
     * 处理自定义异常的返回
     * @param appException
     * @return
     */
    @ResponseBody
    @ExceptionHandler({AppException.class})
    public Response handleAppException(AppException appException){
        log.error("发生异常，代码【{}】，消息【{}】",appException.getCode(),appException.getMessage());
        return Response.fail(appException.getBaseResultCode());
    }

    @ExceptionHandler({AppException.class})
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    // 产生html类型的数据；浏览器发送的请求来到这个处理方法
    public ModelAndView herrorHtml(HttpServletRequest request, HttpServletResponse response,AppException appException) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = Collections
                .unmodifiableMap(getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        model.put("code",appException.getCode());

        //找到错误页面视图名
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
    }

}
