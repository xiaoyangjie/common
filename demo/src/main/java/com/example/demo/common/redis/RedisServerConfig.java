/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.example.demo.common.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.OxmSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * description
 *
 * @author yangjie [yang.jie@unisinsight.com]
 * @date 2019/08/05 15:41
 * @since 1.0
 */

@Configuration
@EnableCaching
@EnableConfigurationProperties(RedisConfigurationProperties.class)
public class RedisServerConfig {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServerConfig.class);

    /**
     * 序列化限定
     */
    private Set<String> allSerializer = new HashSet<>();

    /**
     * 序列化配置
     */
    private RedisConfigurationProperties properties;

    RedisServerConfig(RedisConfigurationProperties redisConfigurationProperties) {
        this.properties = redisConfigurationProperties;
    }

    /**
     * 存储管理
     * @param connectionFactory 参数
     * @return 结果
     */
    @Bean(name = "cacheManagerCommon")
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);

        //redis緩存配置
        RedisCacheConfiguration commonCacheConfig = getRedisCacheConfiguration();

        //初始化RedisCacheManager
        Map<String, RedisCacheConfiguration> map = this.initialCacheConfiguration();
        if (Objects.isNull(map) || map.size() == 0) {
            return new RedisCacheManager(redisCacheWriter, commonCacheConfig);
        }
        return new RedisCacheManager(redisCacheWriter, commonCacheConfig, map);
    }

    /**
     *  redis模板
     * @param factory 参数
     * @return 结果
     */
    @Bean(name = "redisTemplateCommon")
    public <V> RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        //初始化类型
        allSerializer.add(RedisConstant.JACKSON);
        allSerializer.add(RedisConstant.GJACKSON);
        allSerializer.add(RedisConstant.STRING);
        allSerializer.add(RedisConstant.GSTRING);
        allSerializer.add(RedisConstant.JDK);
        allSerializer.add(RedisConstant.OMX);
        RedisTemplate<String, V> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(serializerInit(properties.getKey()));
        template.setValueSerializer(serializerInit(properties.getValue()));
        template.setHashKeySerializer(serializerInit(properties.getHashKey()));
        template.setHashValueSerializer(serializerInit(properties.getHashValue()));

        template.afterPropertiesSet();
        return template;
    }

    /**
     * 序列化
     * @param serial
     * @return
     */
    @SuppressWarnings("unchecked")
    private RedisSerializer serializerInit(String serial) {
        if (RedisConstant.STRING.equals(serial)) {
            return new StringRedisSerializer();
        }
        if (RedisConstant.JACKSON.equals(serial)) {
            Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            return jackson2JsonRedisSerializer;
        }
        if (RedisConstant.GJACKSON.equals(serial)) {
            return new GenericJackson2JsonRedisSerializer();
        }

        if (RedisConstant.GSTRING.equals(serial)) {
            return new GenericToStringSerializer(Object.class);
        }
        if (RedisConstant.JDK.equals(serial)) {
            return new JdkSerializationRedisSerializer();
        }
        if (RedisConstant.OMX.equals(serial)) {
            return new OxmSerializer();
        }
        return new StringRedisSerializer();
    }

    /**
     * 自定義redis緩存配置
     * @return
     */
    @SuppressWarnings("unchecked")
    private RedisCacheConfiguration getRedisCacheConfiguration() {

        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        //redisCache  value序列化
        defaultCacheConfig.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializerInit(properties.getValue())));
        //设置默认超过期时间， 默认是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(properties.getCacheTime()));

        return defaultCacheConfig;
    }

    /**
     * 特殊key值缓存策略
     * @return
     */
    private Map<String, RedisCacheConfiguration> initialCacheConfiguration() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        if (StringUtils.isBlank(properties.getInitCache())) {
            return null;
        }
        //需要初始化的特殊key
        for (String str : properties.getInitCache().split(RedisConstant.BRANCH)) {
            //str為空或者沒有包含“,”
            if (StringUtils.isBlank(str) || !str.contains(RedisConstant.COMMA) || str.split(RedisConstant.COMMA).length != 2) {
                continue;
            }
            String key = str.split(RedisConstant.COMMA)[0];
            Integer time = RedisUtil.str2Integer(str.split(RedisConstant.COMMA)[1]);
            time = Objects.nonNull(time) ? time : properties.getCacheTime();
            LOGGER.info("特殊redis緩存的key為{}，緩存時間為{}", key, time);
            redisCacheConfigurationMap.put(key, this.getRedisCacheConfiguration().entryTtl(Duration.ofSeconds(time)));
        }

        return redisCacheConfigurationMap;
    }
}
