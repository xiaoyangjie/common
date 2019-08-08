/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.demo.common.redis;

/**
 * description
 *
 * @author yangjie [yang.jie@unisinsight.com]
 * @date 2019/07/31 19:16
 * @since 1.0
 */
public class RedisConstant {

    private RedisConstant() {

    }

    /**
     * 序列化配置名
     */
    public static final String STRING = "string";
    public static final String GJACKSON = "gjackson";
    public static final String JACKSON = "jackson";
    public static final String GSTRING = "gstring";
    public static final String JDK = "jdk";
    public static final String OMX = "omx";

    /**
     * CACHE_EXPIRE_TIME
     */
    public static final int CACHE_EXPIRE_TIME = 30;

    /**
     * 逗號
     */
    public static final String COMMA = ",";

    /**
     * 分號
     */
    public static final String BRANCH = ";";

    /**
     * 最大的进制转化
     */
    public static final int RADIX_MAX = 32;

    /**
     * 默認進制數
     */
    public static final int DEFAULT_RADIX = 10;

    /**
     * ERROR_MESSAGE
     */
    public static final String ERROR_MESSAGE = "進制數的區間範圍是：1-32";


}
