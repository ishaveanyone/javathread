package com.dist.javalock;

import org.junit.Test;

/**
 * Created by Administrator on 2019/5/13.
 */
//创建线程的两种方式
class  MyThread extends Thread{

    public MyThread() {
    }

    @Override
    public void run() {
        super.run();

        System.out.println("执行我的线程1");
    }
}
class  MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("执行我的线程2");
    }
}
public class TestTheard0 {
    @Test
    public  void testCreate0() {
        MyThread thread=new MyThread();

        thread.start();
    }

    @Test
    public  void testCreate1() {




        new Thread(() -> {

        }).start();
    }

    @Test
    public  void testCreate2() {



        Thread thread=new Thread(() -> System.out.println("测试线程"));
        Thread thread1=new Thread(() -> System.out.println("测试线程"));
        System.out.println( thread.getContextClassLoader().getClass().getName());
        System.out.println(thread.getName());

        System.out.println("男".indexOf("男"));
        System.out.println(thread.getThreadGroup().getName());

        System.out.println(thread.countStackFrames());

        System.out.println(thread.isDaemon());

        System.out.println(thread.holdsLock(thread));




    }

    @Test
    public  void testCreate3() {

        /*Thread thread1=new Thread(() -> {
            while(true){

                System.out.println("1子线程执行");
            }
        });

        Thread thread2=new Thread(() -> {
            while(true){

                System.out.println("2子线程执行");

            }
        });

        thread1.start();
        thread2.start();*/

       /*new Thread(() -> {
           while (true){
               System.out.println("测试");
           }
       }).start();*/

    }

    public static void main(String[] args) {



        Thread thread2= new Thread(() -> {
           for(int i=0;i<1000000000;i++){
               System.out.println("执行到 ："+i);
           }
        });
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StackTraceElement[] stackTraceElements= thread2.getStackTrace();
        System.out.println(        stackTraceElements[stackTraceElements.length-1].toString());
        try {
            thread2.stop();
        }catch (ThreadDeath t){
            throw t;
        }

        System.out.println("主线程");

        MyThread3 myThread3=new MyThread3();
        myThread3.test();

    }
}
