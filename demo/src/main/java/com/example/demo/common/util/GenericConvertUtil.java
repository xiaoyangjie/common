package com.example.demo.common.util;

import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
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

    public static <T> T genericString2Class(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        T temp = null;
        try {
            temp = JSON.parseObject(str, new TypeReference<T>(){});
        } catch (Exception e) {
            LOGGER.error("解析失败");
        }
        return temp;
    }

}
