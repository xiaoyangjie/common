package com.example.demo.thread;

import com.example.demo.common.thread.ThreadPoolUtil;
import com.example.demo.dto.response.A;
import com.example.demo.dto.response.B;
import com.example.demo.job.ThreadPoolJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    private final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);

    @Resource
    private ThreadPoolUtil threadPoolUtil;

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void test() {

        ThreadLocal<Integer> local = new ThreadLocal<>();
        ThreadLocal<Integer> local1 = new ThreadLocal<>();

        Thread t = Thread.currentThread();
        local.get();
        local.set(new Integer(1111));
        System.gc();
        local1.set(333);
        System.out.println(111);

    }

    @Test
    public void test1() {
        String base = "String";
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            System.out.println(str.length());
            base = str.intern();
            System.gc();

        }
    }



}
