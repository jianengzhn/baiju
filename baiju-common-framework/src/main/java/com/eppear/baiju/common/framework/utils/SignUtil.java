package com.eppear.baiju.common.framework.utils;

import com.eppear.baiju.common.framework.common.Signature;
import com.eppear.baiju.common.framework.constant.ConfigConstants;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * URL签名生成与验证工具类,参照了微信签名的方式
 *
 * @author jianf
 * @date 2020年05月20 15:57
 */
public class SignUtil {

    /**
     * 验证签名
     * @param sgt 待验证对象
     * @return true 签名一致， false 签名不一致
     */
    public static boolean checkSignature(Signature sgt) {

        Long curTt = (System.currentTimeMillis() / 1000);
        String timestamp = sgt.getTimestamp();
        Long sgtTt = Long.valueOf(timestamp) + Long.valueOf(ConfigConstants.WEBSOCKET_SIGN_TIMEOUT);
        // 超时也认为是无效签名
        if (curTt > sgtTt) {
            return false;
        }
        String signature = sgt.getSignature();
        String tmpStr = createSign(sgt);
        return (tmpStr != null && signature != null) && tmpStr.equals(signature.toUpperCase());
    }

    /**
     * 生成对应信息的签名,生成的过程中会补充时间戳和随机字符串
     *
     * @param sgt
     *            需要生成的信息
     * @return 已生成签名的全部信息
     */
    public static Signature generateSign(Signature sgt) {
        sgt.setTimestamp(createTimestamp());
        sgt.setNonce(createNonce());
        sgt.setSignature(createSign(sgt));
        return sgt;
    }

    /**
     * 生成时间戳,以秒为单位
     *
     * @return
     */
    public static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 生成随机字符串
     *
     * @return
     */
    public static String createNonce() {
        return StrUtils.uuid().replaceAll("-", "");
    }

    /**
     * 根据给定的参数,计算出签名信息
     *
     * @param sgt
     * @return
     */
    private static String createSign(Signature sgt) {
        String id = sgt.getId();
        String timestamp = sgt.getTimestamp();
        String nonce = sgt.getNonce();
        String token = sgt.getToken();

        String[] arr = new String[] { token, timestamp, nonce, id };
        // 将token、timestamp、nonce,id参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String signature = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将四个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            signature = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        return signature;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
