package com.dist.javalock;

/**
 * Created by Administrator on 2019/5/16.
 */
public class SingleTest {
//    默认是 包含模式  线程安全的
   /* private static SingleTest ourInstance = new SingleTest();

    public static SingleTest getInstance() {
        return ourInstance;
    }

    private SingleTest() {
    }*/


   private static volatile SingleTest singleTest=null;

    public static SingleTest getInstance() {
//        线程不安全的 推荐使用volatile 防止指令重排序

        if(singleTest==null){
            singleTest= new SingleTest();
        }
        return singleTest;
    }

    private SingleTest() {
    }
}
