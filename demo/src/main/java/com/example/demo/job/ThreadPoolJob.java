package com.example.demo.job;

public class ThreadPoolJob extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("111111111111");
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
