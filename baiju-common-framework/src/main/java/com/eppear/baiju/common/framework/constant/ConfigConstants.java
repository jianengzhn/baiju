package com.eppear.baiju.common.framework.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 *  系统级配置文件及常量
 *
 * @author jianf
 * @date 2020年05月20 16:30
 */
@Component
public class ConfigConstants {

    /**
     * 服务器地址
     */
    public static String WEBSOCKET_URL ="";
    /**
     * 客户端ID
     */
    public static String WEBSOCKET_ID ="";
    /**
     * 通讯tocken
     */
    public static String WEBSOCKET_TOKEN ="";
    /**
     * 通讯等待最长时间(毫秒)
     */
    public static String WEBSOCKET_TIMEOUT ="";
    /**
     * 签名有效时间(秒)
     */
    public static String WEBSOCKET_SIGN_TIMEOUT ="";


    @Value("${websocket.sign.timeout:50}")
    private void setWebsocketSignTimeout(String wst ){
        WEBSOCKET_SIGN_TIMEOUT = wst;
    }
}
