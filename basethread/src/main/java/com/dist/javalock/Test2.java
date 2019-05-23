package com.dist.javalock;

/**
 *
 * juc 中也包含了 大量的原子类
 * 线程中断方法
 * Created by Administrator on 2019/5/14.
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        /*Thread thread=new Thread(() -> {
            synchronized (Test2.class) {
                while (true) {
                    System.out.println(11);
                }
            }

        });
        Thread thread2=new Thread(() -> {
            synchronized (Test2.class) {
                System.out.println("执行第二个线程");
            }

        });
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread.stop();

        System.out.println("已经执行stop方法");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    /*    Thread thread=new Thread(() -> {

                Thread.currentThread().interrupt();

                System.out.println("----------------------" + Thread.interrupted());
                System.out.println("----------------------" + Thread.interrupted());

        });
        thread.start();


        System.out.println(thread.isInterrupted());
*/


    }

}
