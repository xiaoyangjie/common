/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.demo.common.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * description：实现自定义方法
 *
 * @author yangjie [yang.jie@unisinsight.com]
 * @date 2019/07/31 19:57
 * @since 1.0
 */
@Component
@SuppressWarnings("unchecked")
public class RedisServerCustom  extends RedisServer {

    /**
     * redisTemplate
     */
    @Resource(name = "redisTemplateCommon")
    private RedisTemplate redisTemplate;

    /** -------------------自定义方法-------------- */
    /**
     * 查询key值是否存在
     * @param key
     * @return Long
     */
    public Boolean hasKeyO(String key) {
        Object result = redisTemplate.execute(new RedisCallback() {
            @Override
            public Boolean doInRedis(RedisConnection connection) {
                Boolean flag = false;
                if (Objects.nonNull(key)) {
                    flag = connection.exists(key.getBytes());
                }
                return flag;
            }
        });
        return (Boolean) result;
    }
}
