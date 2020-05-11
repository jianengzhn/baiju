package com.eppear.baiju.controller;

import com.eppear.baiju.common.framework.constant.AppResultCodeEnum;
import com.eppear.baiju.common.framework.execption.AppException;
import com.eppear.baiju.common.framework.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试类
 * @author zjf
 * @date 2020-05-11 22:11:31
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("1")
    public String test1() {
        throw new AppException(AppResultCodeEnum.PARAM_NOT_COMPLETE);
        //return "";
    }

    @ResponseBody
    @RequestMapping("2")
    public Response test2(){
        throw new AppException(AppResultCodeEnum.PARAM_NOT_VALID);
        //return Response.fail(AppResultCodeEnum.NO_PERMISSION);
    }
}
