package com.eppear.baiju.common.framework.constant;

/**
 * 全局异常错误码<br>
 * 规定:<br>
 * #200 表示成功 <br>
 * #999  默认失败<br>
 *
 * #1001～1999 区间表示参数错误 <br>
 * #2001～2999 区间表示用户错误 <br>
 * #3001～3999 区间表示接口异常 <br>
 *
 * @author jianf
 * @date
 */
public enum AppResultCodeEnum implements BaseResultCode {

    /** 成功 */
    SUCCESS(200, "操作成功"),
    /**
     * 系统异常，即业务代码以外的，无法预知的异常
     */
    SYS_EXCEPTION(990, "系统内部异常"),
    /** 默认失败 */
    COMMON_FAIL(999, "操作失败"),

    /** 参数错误：1000～1999 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /** 用户错误 */
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    USER_ACCOUNT_DISABLE(2005, "账号不可用"),
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
    USER_ACCOUNT_USE_NAME_NOT_NULL(2010, "用户账号不能为空"),

    /** 业务错误 */
    NO_PERMISSION(3001, "没有权限");

    private Integer code;
    private String message;

    AppResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
    @Override
    public String getMessage() {
        return this.message;
    }

    /**
     * 根据code获取message
     *
     * @param code 结果编码
     * @return 结果消息
     */
    public static String getMessageByCode(Integer code) {
        for (AppResultCodeEnum ele : values()) {
            assert ele.getCode() != null;
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }

}
