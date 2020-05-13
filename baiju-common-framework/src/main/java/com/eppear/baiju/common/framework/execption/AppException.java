package com.eppear.baiju.common.framework.execption;

import com.eppear.baiju.common.framework.constant.BaseResultCode;

/**
 * 异常基类.<p>
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
    private final String description;
    /**
     * 自定义枚举
     */
    private final BaseResultCode baseResultCode;

    /**
     * 构造方法
     * @param baseResultCode 异常信息枚举类
     */
    public AppException(final BaseResultCode baseResultCode) {
        super(baseResultCode.getMessage());
        this.code = baseResultCode.getCode();
        this.description = baseResultCode.getMessage();
        this.baseResultCode = baseResultCode;
    }

    /*public AppException(Integer code, String message, BaseResultCode baseResultCode){
        this.code = code;
        this.message = message;
        this.baseResultCode = baseResultCode;
    }*/

    /**
     * 获取异常代码.
     * @return 异常代码
     */
    public Integer getCode() {
        return this.code;
    }
    /**
     * 获取异常消息.
     * @return 异常消息
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 获取异常信息枚举.
     * @return 信息枚举
     */
    public BaseResultCode getBaseResultCode() {
        return this.baseResultCode;
    }
}
