package com.example.demo.common.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NormalHandler implements InvocationHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(NormalHandler.class);

    private Object target;

    public NormalHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info("man say invoked at : {}", System.currentTimeMillis());
        method.invoke(target, args);
        return null;
    }
}
