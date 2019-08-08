/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.demo.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * description
 *
 * @author yangjie [yang.jie@unisinsight.com]
 * @date 2019/07/31 19:15
 * @since 1.0
 */
@ConfigurationProperties(prefix = "spring.redis.serializer")
public class RedisConfigurationProperties {

    /**
     * redis序列化key
     */
    private String key = RedisConstant.STRING;

    /**
     * redis序列化value
     */
    private String value = RedisConstant.GJACKSON;

    /**
     * redis序列化hashKey, 配置时使用hash-key
     */
    private String hashKey = RedisConstant.STRING;

    /**
     * redis序列化hashValue,配置时使用hash-value
     */
    private String hashValue = RedisConstant.GJACKSON;

    /**
     *  RedisCache缓存时间，默认是30秒
     */
    private int cacheTime = RedisConstant.CACHE_EXPIRE_TIME;

    /**
     * 初始化的cache值， 格式為  key1,time1(s);key2,time2(s)    如test1,1000;test2,3000
     */
    private String initCache = "";


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }

    public String getInitCache() {
        return initCache;
    }

    public void setInitCache(String initCache) {
        this.initCache = initCache;
    }
}
