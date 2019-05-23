package com.dist.javalock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 内置锁 显示锁
 *
 * java在代码现实上面 区分出来了内置锁 以及 显示锁
 * 使用 synchronized 就是内置锁
 * 使用 Lock就是显示锁
 * java 在1.5之后引入了显示锁
 *
 *
 * 在之前java中任何对象都能作为锁 ，为了区别
 */

public class BuiltInDisplayLock {
//    内置锁
    //作用在实例方法上 锁就是this
    private static Object object=new Object();
    private static int count =0;
    static Lock lock = new ReentrantLock(true);    //注意这个地方 这个是一个可重入锁
    static Condition condition=lock.newCondition();


    public synchronized void test(){
        int count =0;
        for(int i=0;i<100;i++){
            count++;
        }
    }
    //作用在静态方法上 锁就是类字节码对象
    public synchronized static  void testStatic(){
        int count =0;
        for(int i=0;i<100;i++){
            count++;
        }
    }
    //作用在块上 锁就是    object 对象
    public synchronized static  void testBlock(){
        synchronized (object) {
            int count = 0;
            for (int i = 0; i < 100; i++) {
                count++;
            }
        }
    }
//显示锁(ReentrantLock)
    public static void insert() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }

    public static void insert2() {
//        Thread currentThread=((ReentrantLock) lock).



     /*   if(((ReentrantLock) lock).isLocked()){
            lock.unlock();
        }*/
        if(((ReentrantLock)lock).getHoldCount()==1){
            lock.lock();
        }
        if(!((ReentrantLock) lock).isHeldByCurrentThread()){
            lock.lock();
        }
        System.out.println(((ReentrantLock) lock).isFair());
        System.out.println(((ReentrantLock) lock).hasQueuedThreads());
        System.out.println(((ReentrantLock) lock).hasQueuedThread(Thread.currentThread()));
        System.out.println(((ReentrantLock) lock).getQueueLength());
        try {
            System.out.println(Thread.currentThread().getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }
//显示锁(ReentrantLock)

    /*
    *   线程1调用reentrantLock.lock时，线程被加入到AQS的等待队列中。
        线程1调用await方法被调用时，该线程从AQS中移除，对应操作是锁的释放。
        接着马上被加入到Condition的等待队列中，以为着该线程需要signal信号。
        线程2，因为线程1释放锁的关系，被唤醒，并判断可以获取锁，于是线程2获取锁，并被加入到AQS的等待队列中。
        线程2调用signal方法，这个时候Condition的等待队列中只有线程1一个节点，于是它被取出来，并被加入到AQS的等待队列中。 注意，这个时候，线程1 并没有被唤醒。
signal方法执行完毕，线程2调用reentrantLock.unLock()方法，释放锁。这个时候因为AQS中只有线程1，于是，AQS释放锁后按从头到尾的顺序唤醒线程时，线程1被唤醒，于是线程1回复执行。
直到释放所整个过程执行完毕。
    * */
    public static void insert3() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获得锁");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

       /* BuiltInDisplayLock builtInDisplayLock=
                new BuiltInDisplayLock();

        new Thread(() -> {
            builtInDisplayLock.test();
        }).start();
        new Thread(() -> {
            builtInDisplayLock.test();
        }).start();*/

      /*  for(int i=0;i<100;i++){
            new Thread(() -> {
                insert2();
            }).start();
        }
        boolean flag =false;
        while (true){
            while(Thread.activeCount()==2){

                System.out.println(count);
                flag=true;
                break;
            }
            if(flag){
                break;
            }
        }*/

      /*  new Thread(() -> {
            lock.lock();
            try {
                System.out.println("已经拿到锁1");
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("执行结束1");
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("已经拿到锁2");
                condition.signal();//注意这个时候 线程一并没有被唤醒 只不过是加入了aqs队列当中
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("执行结束2");
                lock.unlock();
            }
        }).start();*/

       /* Thread thread1= new Thread(() -> {
            try {
                lock.lockInterruptibly();
                condition.await();
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("已经拿到锁1");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("执行结束1");
                lock.unlock();
            }
        });
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2= new Thread(() -> {
            lock.lock();
            try {
                System.out.println("已经拿到锁2");
                thread1.interrupt();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("执行结束2");
                lock.unlock();
            }
        });
       thread2.start();*/
       methodA();
    }


    public static void  methodA(){
        lock.lock();
        System.out.println("执行方法A");
        methodB();
        lock.unlock();
    }


    public static void  methodB(){
        lock.lock();
        System.out.println("执行方法B");

        lock.unlock();
    }

}
