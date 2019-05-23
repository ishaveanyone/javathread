package com.dist.javalock;

import org.junit.Test;
import sun.misc.PostVMInitHook;

import java.io.IOException;

/**
 * Created by Administrator on 2019/5/14.
 */
public class Test1{

    public static void main(String[] args) throws InterruptedException {
        /*Thread thread=new Thread(() -> {


            while (true){
                System.out.println(1);
            }

        });

        thread.start();*/
/*
        Thread thread1=new Thread(() -> {

            synchronized (Test1.class){
                try {
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2=new Thread(() -> {

            synchronized (Test1.class){

            }
        });

        thread2.start();*/
       /* Object o=new Object();
        Thread thread2=new Thread(() -> {
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        thread2.start();*/


      /* Thread thread=new Thread(() -> {
           System.out.println("执行run方法");
           Thread.currentThread().suspend();
           System.out.println("run方法执行结束");
       });
        thread.start();

        Thread.sleep(20000);

        thread.resume();*/


     /* Thread thread1=new Thread(() -> {
          synchronized (Test1.class){
              System.out.println(Thread.currentThread().getName()+"：获取锁资源");
              Thread.currentThread().suspend();
              System.out.println(Thread.currentThread().getName()+"：释放锁资源");

          }
      });
      thread1.start();
      Thread.sleep(100);
    Thread thread2=new Thread(() -> {
        synchronized (Test1.class){
            System.out.println(Thread.currentThread().getName()+"：获取锁资源");
            System.out.println(Thread.currentThread().getName()+"：释放锁资源");
        }
    });
    thread2.start();*/
     Object o=new Object();
     Thread thread1=new Thread(() -> {
         synchronized (o) {

             try {
                 System.out.println("执行run方法");

                 o.wait(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("执行run方法结束");

         }

     });
     thread1.start();
     Thread.sleep(1000L);
        Thread thread2=new Thread(() -> {
            synchronized (o) {

                System.out.println("执行run方法");
                System.out.println("执行run方法结束");
                try {
                    o.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
        thread2.start();




    }



}
