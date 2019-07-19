package com.example.demo.common.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Man implements Person, Cloneable{

    public Man() {
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(Man.class);

    @Override
    public void say() {
        String str;
        LOGGER.info("test proxy");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
