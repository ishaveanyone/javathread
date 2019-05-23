package com.dist.javalock;


public class MyThread3 implements Runnable{

    @Override
    public void run() {
        System.out.println("我的线程3");
    }

    public static void test(){
        System.out.println("测试1");
    }


}
