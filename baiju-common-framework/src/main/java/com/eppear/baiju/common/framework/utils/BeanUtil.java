package com.eppear.baiju.common.framework.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean 复制工具
 *
 * @author jianf
 * @date 2020年05月15 17:20
 */
public class BeanUtil {

    public static String[] getNullPropertyNames(Object source,String... properNames) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyNames.add(pd.getName());
            }
        }
        if(StringUtils.isNotNull(properNames)) {
            Arrays.stream(properNames.clone()).forEach(e -> {
                emptyNames.add(e);
            });
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 非空拷贝
     * @param source 源对像
     * @param target 目标对像
     */
    public static void copyNotNullBean(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    /**
     * 非空拷贝
     * @param source
     * @param target
     * @param properNames 无需要复制的属性
     */
    public static void copyNotNullBean(Object source, Object target,String... properNames) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source,properNames));
    }
}
