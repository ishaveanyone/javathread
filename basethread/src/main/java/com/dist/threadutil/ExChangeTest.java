package com.dist.threadutil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

/**
 * 交换数据 操作必须成对出现
 * Created by Administrator on 2019/5/22.
 */
public class ExChangeTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(2);

        Exchanger exchanger=new Exchanger();
       final String str1="a";
         final   String str2="b";
        Integer a=0;
        new Thread(() -> {

            try {
                System.out.println("执行str1"+exchanger.exchange(str1));
                countDownLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {

            try {
                countDownLatch.countDown();
                System.out.println("执行str2"+exchanger.exchange(str2));

                System.out.println("执行str2存值");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("开始等待。。。");
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str1);
            System.out.println(str2);
        }).start();




    }
}
