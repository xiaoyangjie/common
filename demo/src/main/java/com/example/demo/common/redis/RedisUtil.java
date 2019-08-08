/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.demo.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * description
 *
 * @author yangjie [yang.jie@unisinsight.com]
 * @date 2019/07/31 20:25
 * @since 1.0
 */
public class RedisUtil {

    private RedisUtil() {

    }
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * 强制转换
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> T cast(Object obj) {
        T t;
        try {
            t = (T) obj;
        } catch (Exception e) {
            LOGGER.error("强制转换异常");
            return null;
        }
        return t;
    }

    /**
     * Boolean去空
     *
     * @return
     */
    public static boolean removeNull(Boolean flag) {
        return Objects.isNull(flag) || flag;
    }

    /**
     * 设置默认值
     * @param s
     * @return 解析错误返回null
     */
    public static Integer str2Integer(String s) {
        return str2Integer(s, RedisConstant.DEFAULT_RADIX);
    }

    /**
     *
     * @param s     數字字符串
     * @param radix  進制數
     * @return  如果有錯誤，則返回null
     */
    public static Integer str2Integer(String s, int radix) {
        Integer i = null;
        if (radix < 1 || radix > RedisConstant.RADIX_MAX) {
            LOGGER.error(RedisConstant.ERROR_MESSAGE);
            return null;
        }
        try {
            i = Integer.parseInt(s, radix);
        } catch (NumberFormatException e) {
            LOGGER.error("轉化錯誤");
        }
        return i;
    }


}
