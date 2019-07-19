package com.example.demo.common.util;

import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import com.alibaba.fastjson.JSON;

/**
 *  转化给
 */

public class GenericConvertUtil {

    /**
     * log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericConvertUtil.class);

    private GenericConvertUtil() {
    }

    public static <T> T genericString2Class(String str, T clazz) {
        if (Objects.isNull(str)) {
            return null;
        }
        JSON.parseObject(str, new TypeReference<T>(){});
    }

}
