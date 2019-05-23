package com.dist.threadutil;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 并发工具类 一般用于某一个线程等待其他线程执行结束后继续执行，是不可重用的
 * Created by Administrator on 2019/5/21.
 */
public class ThreadUtilTest {

//            CountDownLatch countDownLatch;
//    可以控制指定线程数量 的 等到所有的线程执行完毕之后 进行线程的 继续的执行
    public static void main(String[] args) {

//        指定八个线程执行的动作
        CountDownLatch countDownLatch=new CountDownLatch(8);

        for(int i=0;i<8;i++){
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("所有线程执行完毕休眠操作，现在继续运行");
            }).start();
        }
        for(int i=1;i<=8;i++){

            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI *1000);
                    System.out.println(Thread.currentThread().getName()+"休眠完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
