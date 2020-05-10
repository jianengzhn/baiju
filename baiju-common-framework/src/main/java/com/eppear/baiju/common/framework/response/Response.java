package com.eppear.baiju.common.framework.response;

import com.eppear.baiju.common.framework.constant.AppResultCodeEnum;
import com.eppear.baiju.common.framework.constant.BaseResultCode;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>通用返回抽像类</p>
 * 用于Controller向外返回，无分页属性的情况
 *
 * @author jianf
 * @date 2020年05月10 17:46
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -8629602136533811984L;
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String description;
    /**
     * 响应附加参数
     */
    private String parameterData = "";
    /**
     * 响应数据
     */
    private T data;

    /**
     * 空参构造
     */
    public Response(){
        this(AppResultCodeEnum.SUCCESS.getCode(),AppResultCodeEnum.SUCCESS.getMessage(),
                null,null);
    }

    private Response(Integer code, String description, T data, String parameterData){
        super();
        this.code = code;
        this.description = description;
        this.data = data;
        this.parameterData = parameterData;
    }

    /**
     *  内部通用初始化方法
     * @param code 异常代码枚举类
     * @param data 响应数据实体
     * @param parameterData 响应附加参数
     * @return 响应实体
     */
    private static<T> Response<T> init(BaseResultCode code, T data, String parameterData){
        return new Response<>(code.getCode(), code.getMessage(), data, parameterData);
    }

    /**
     * 成功
     * @return 响应实体
     */
    public static Response success(){
        return new Response();
    }

    /**
     * 成功
     * @param data 响应数据
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> success(T data){
        return init(AppResultCodeEnum.SUCCESS,data,null);
    }

    /**
     *  操作成功
     * @param data 响应数据
     * @param parameterData 附加响应参数
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> success(T data, String parameterData){
        return init(AppResultCodeEnum.SUCCESS,data,parameterData);
    }

    /**
     *  成功
     * @param data 响应数据
     * @param baseResultCode 附加响应参数
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> success(T data, BaseResultCode baseResultCode){
        return init(baseResultCode,data,null);
    }

    /**
     * 成功
     * @param data 响应数据
     * @param parameterData 附加响应参数
     * @param baseResultCode 成功代码
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> success(T data, String parameterData, BaseResultCode baseResultCode){
        return init(baseResultCode,data,parameterData);
    }

    /**
     * 失败
     * @return 默认失败响应消息
     */
    public static Response fail(){
        return init(AppResultCodeEnum.COMMON_FAIL,null,null);
    }

    /**
     * 失败
     * @param baseResultCode 失败代码
     * @return 响应实体
     */
    public static Response fail(BaseResultCode baseResultCode ){
        return init(baseResultCode,null,null);
    }

    /**
     * 失败
     * @param baseResultCode 失败代码
     * @param parameterData 附加响应参数
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> fail(BaseResultCode baseResultCode, String parameterData){
        return init(baseResultCode,null,parameterData);
    }

    /**
     * 失败
     * @param baseResultCode 失败响应代码
     * @param data 响应数据
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> fail(BaseResultCode baseResultCode, T data){
        return init(baseResultCode,data,null);
    }

    /**
     * 失败
     * @param baseResultCode 失败响应代码
     * @param data 响应数据
     * @param parameterData 附加响应参数
     * @param <T>
     * @return 响应实体
     */
    public static <T> Response<T> fail(BaseResultCode baseResultCode, T data, String parameterData){
        return init(baseResultCode,data,parameterData);
    }

    /**
     * 响应是否成功
     * @return true-成功，false-失败
     */
    public Boolean isSuccess(){
        return Objects.equals(AppResultCodeEnum.SUCCESS.getCode(),getCode());
    }
}
