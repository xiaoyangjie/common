package com.example.demo.thread;

import com.example.demo.common.thread.ThreadPoolUtil;
import com.example.demo.job.ThreadPoolJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    private final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);

    @Resource
    private ThreadPoolUtil threadPoolUtil;

    @Test
    public void test() {
        ExecutorService pool  =  threadPoolUtil.getPool();

        ThreadPoolJob threadPoolJob;
        for (int i = 0; i < 100; i++) {
            threadPoolJob = new ThreadPoolJob();
            LOGGER.info("========{}", i);
            pool.execute(threadPoolJob);
            LOGGER.info("========{}=========", i);

        }

    }


}
