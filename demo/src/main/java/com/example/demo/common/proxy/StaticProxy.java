package com.example.demo.common.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StaticProxy implements Person{

    private Person target;

    private static final Logger LOGGER = LoggerFactory.getLogger(Man.class);

    public Person getTarget() {
        return target;
    }

    public StaticProxy setTarget(Person target) {
        this.target = target;
        return this;
    }

    @Override
    public void say() {
        if (target != null) {
            LOGGER.info("man say invoked at : {}", System.currentTimeMillis());
            target.say();
        }
    }

}
