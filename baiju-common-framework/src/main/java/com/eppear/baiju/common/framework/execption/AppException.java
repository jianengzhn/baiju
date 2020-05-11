package com.eppear.baiju.common.framework.execption;

import com.eppear.baiju.common.framework.constant.BaseResultCode;

/**
 * 异常基类<p>
 *     所有自定义异常都应为其子类 Abstract
 *
 * @author jianf
 * @date 2020年05月10 10:37
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -9090589742877708753L;
    /**
     * 自定义异常代码
     */
    private final Integer code;
    /**
     * 自定定义异常说明
     */
    private final String message;
    /**
     * 自定义枚举
     */
    private final BaseResultCode baseResultCode;

    public AppException(BaseResultCode baseResultCode){
        super(baseResultCode.getMessage());
        this.code = baseResultCode.getCode();
        this.message = baseResultCode.getMessage();
        this.baseResultCode = baseResultCode;
    }

    /*public AppException(Integer code, String message, BaseResultCode baseResultCode){
        this.code = code;
        this.message = message;
        this.baseResultCode = baseResultCode;
    }*/

    /**
     * 获取异常代码
     * @return
     */
    public Integer getCode() {
        return this.code;
    }
    /**
     * 获取异常消息
     * @return
     */
    @Override
    public String getMessage(){
        return this.message;
    }

    /**
     * 获取异常信息枚举
     * @return
     */
    public BaseResultCode getBaseResultCode(){
        return this.baseResultCode;
    }
}
