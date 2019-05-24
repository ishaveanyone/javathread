package com.dist.threadpool;


import com.sun.org.apache.xalan.internal.utils.FeatureManager;
import org.testng.annotations.Test;

import java.util.concurrent.*;

/**
 * 线程池 测试
 * Created by Administrator on 2019/5/22.
 */
public class ThreadPoolTest {

    //    测试创建 线程池
    @Test(timeOut = 1000)
    public void testCreate0(){
        LinkedBlockingQueue<Runnable> linkedBlockingQueue=new LinkedBlockingQueue();
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(10,
        20,
        3L,
        TimeUnit.SECONDS, linkedBlockingQueue);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        for(int i=0;i<100;i++){
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":创建成功，并且被调用");
            });
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        LinkedBlockingQueue<Runnable> linkedBlockingQueue=new LinkedBlockingQueue();
        ThreadPoolExecutor threadPoolExecutor=
                new ThreadPoolExecutor(10,
                        20,
                        3L,
                        TimeUnit.SECONDS, linkedBlockingQueue);
        Future<String> future=null;
        for(int i=0;i<100;i++){
            int finalI=i;
            future=threadPoolExecutor.submit(() -> {
                Thread.sleep(1000L);
                return "测试使用"+finalI;});
        }




    }

}
