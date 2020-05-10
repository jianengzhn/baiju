package com.eppear.baiju.common.framework.constant;

/**
 * 统一返回码接口定义<p>
 * 所有返回代码类，都用枚举类定义，且实现此接口
 * @author zjf
 * @date 2020-05-09 21:09:50
 */
public interface BaseResultCode {
    /**
     * 获取异常编码
     * @return 异常码
     */
    Integer getCode();

    /**
     * 获取异常信息
     * @return 异常信息
     */
    String getMessage();
}
