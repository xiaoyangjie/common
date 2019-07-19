package com.example.demo.job;


public class ThreadPoolJob extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("正在运行的线程名称：" + this.currentThread().getName() + " 开始");
            Thread.sleep(20000);    //延时20秒
            System.out.println("正在运行的线程名称：" + this.currentThread().getName() + " 结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
