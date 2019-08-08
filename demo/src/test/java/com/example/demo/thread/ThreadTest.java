package com.example.demo.thread;

import com.example.demo.common.test.Stest;
import com.example.demo.common.thread.ThreadPoolUtil;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {
    private int a = 100;

    private final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);

    @Resource
    private ThreadPoolUtil threadPoolUtil;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private Stest<Integer> stest;

    @Test
    public void test() {
        System.out.println(ClassLayout.parseInstance(stest).toPrintable());
    }

    @Test
    public void test1() {

    }

    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");
        System.out.println(s3 == s3.intern());
        System.out.println(1111);
    }

    public class Test1 extends Thread {

        @Override
        public void run() {
            while (a > 0) {
                a--;
                System.out.println(a);
            }
        }
    }


}

