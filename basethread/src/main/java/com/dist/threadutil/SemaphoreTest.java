package com.dist.threadutil;

import java.util.concurrent.Semaphore;

/** 信号 其实相当于是锁的一个集合
 * 只有获取到信号量才能继续执行
 * 使用场景 ： 控制并发数量 进行接口限流
 * Created by Administrator on 2019/5/22.
 */
public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(8);

        for(int i=1;i<20;i++){
            final  int finalI=i;
            new Thread(() -> {
                try {
                    //获取信号量
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获取到信号量");
                    Thread.sleep(finalI*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放信号量
                    semaphore.release();
                }
            }).start();
        }



    }
}
