package com.dist.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2019/5/23.
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask=new FutureTask<String>(() -> "测试用");
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());

    }
}
