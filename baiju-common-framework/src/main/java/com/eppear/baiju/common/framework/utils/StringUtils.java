package com.eppear.baiju.common.framework.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author jianf
 * @date 2020年05月15 17:28
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final char SEPARATOR = '_';
    private  static final String strData ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs) {
        if (str != null) {
            for (String s : strs) {
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip)?"127.0.0.1":ip;
    }

    /**
     * 获得当天是周几
     */
    public static String getWeekDay(){
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekDays[w];
    }


    /**
     * 获取字符串自增长值
     * describe:
     * author:xqc
     * Date:2018/8/7 18:06
     */
    public static String autoGrowth(String str) {
        boolean b = true;
        String beforeStr = "";
        String afterStr = "";
        for (int i = str.length(); i > 0; i--) {
            if (isNumeric(str.substring(i - 1, i)) && b)
                afterStr = str.substring(i - 1, i) + afterStr;
            else {
                b = false;
                beforeStr = str.substring(i - 1, i) + beforeStr;

            }
        }
        Long num = (Long.valueOf("1" + afterStr) + 1);
        String newStr = beforeStr + num.toString().substring(1, num.toString().length());
        return newStr;

    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {

        System.out.println(makeNo("PAY00",2));
        Snowflake snowflake=new Snowflake(1,1);
        System.out.println(snowflake.nextId());
    }
    /**
     * 判断是否传是否为空
     * @param str
     * @return
     */
    public static boolean isNotNull(Object str) {
        if(str instanceof  String) {
            String stt=(String)str;
            if (isEmpty(stt)) {
                return false;
            }
            if ("".equals(stt.trim())) {
                return false;
            }
            return true;
        }
        if(Objects.isNull(str)) {
            return false;
        }
        return true;
    }

    public static String makeNo(String prefix,int randomLen){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String num=String.valueOf(runtimeMXBean.getName().split("@")[0]);
        num=num.substring(num.length()-2,num.length());
        prefix += DateUtil.format(new Date(),"yyMMddHHmmssSSS");
        String code = prefix +num+ StringUtils.randomNum(randomLen);
        return code;
    }


    /**
     * 判断是否传是否为空
     * @param str
     * @return
     */
    public static boolean isNull(Object str){
        return !isNotNull(str);
    }
    /**
     * 首字母 大写
     * @param str
     * @return
     */
    public static String firstUp(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    /**
     * 首字母 小写
     * @param str
     * @return
     */
    public static String firstLow(String str){
        return str.substring(0,1).toLowerCase()+str.substring(1);
    }

    /**
     * 表名称转换成 类名称
     * @param
     * @return
     */
    public static String tableToClass(String tableName){
        StringBuffer className = new StringBuffer();
        String [] names = org.apache.commons.lang3.StringUtils.split(tableName.toLowerCase(), "_") ;
        for(String name:names) {
            className.append(firstUp(name)) ;
        }
        return className.toString() ;
    }

    public static String  randomNum(Integer digCount){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(digCount);
        for(int i=0; i < digCount; i++) {
            sb.append((char) ('0' + rnd.nextInt(10)));
        }
        return sb.toString();

    }

    /**
     * 生成随机字符串，由大小写字母和数字组成
     * @param length 字符串长度
     * @return
     */
    public static String randomStr(Integer length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(strData.charAt(number));
        }
        return sb.toString();
    }
}
