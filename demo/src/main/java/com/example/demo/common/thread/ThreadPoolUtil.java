package com.example.demo.common.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.*;

@Component
public class ThreadPoolUtil {

    private ExecutorService pool;

    private Integer corePoolSize = 3;

    private Integer capaticy = 10;

    private Integer maximumPoolSize = 6;

    @PostConstruct
    public void init() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("demo-pool-%d").build();
        pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(capaticy),
                threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @PreDestroy
    public void destory() {
        pool.shutdown();
    }
    public ExecutorService getPool() {
        return pool;
    }
}
