package com.dist.threadutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 一组线程之间相互等待
 * Created by Administrator on 2019/5/22.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(8);

        for(int i=1;i<=8;i++){
            final int finalI=i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI*1000);
                    System.out.println(Thread.currentThread().getName()+"准备就绪");
                    try {
                        cyclicBarrier.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始比赛");
            }).start();
        }



    }
}
