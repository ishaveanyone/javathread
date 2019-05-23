package com.dist.container;

import org.junit.Test;

import javax.print.attribute.standard.MediaSize;
import java.util.*;
import java.util.concurrent.*;

/**
 * 容器测试
 * Created by Administrator on 2019/5/21.
 */
public class ContainerTest {

//    普通容器 遍历中不能被修改
    @Test
    public void test0() {

        List<String> list=Arrays.asList("1","2","3");
      /*  for(int i=0;i<list.size();i++){
            if(i==0){
//                java.lang.UnsupportedOperationException
                list.remove(i);
            }
            System.out.println(list.get(i));
        }*/

        Iterator<String> iterator= list.iterator();
        while (iterator.hasNext()){
            String next=iterator.next();

            if(next.equals("1")){
                iterator.remove();
            }
        }
        System.out.println(list.size());


    }


        /**
         * 同步容器 分为以下几个
         * 1. vetor stack hashTable
         * 2. Collections 提供的静态类
         *
         * 如果在遍历中需要进行修改 那么使用 iterator 接口进行删除，在多线程下面进行迭代删除遍历的时候需要进行添加synchronize关键词
         */
    @Test
    public void test1() {
        Vector vector = new Vector();
        vector.add("测试使用1");
        vector.add("测试使用2");
     /*   vector.forEach(o -> {
            if(o.equals("测试使用1")){
//                java.util.ConcurrentModificationException
                vector.remove(o);
            }
        });*/
        Iterator<String> iterator=vector.iterator();
        while (iterator.hasNext()){
            String next=iterator.next();
            if(next.equals("测试使用1")){
                iterator.remove();
            }
        }
        System.out.println(vector.size());


        Stack stack = new Stack();
        stack.push("测试");
        System.out.println(stack.pop());

//        使用大量的 synchronize 关键词 阻塞会阻塞 ，降低执行效率
        Map map1 = new Hashtable<>();
        map1.put("a", "b");

//        使用大量的 synchronize 关键词 阻塞会阻塞 ，降低执行效率
        Map map2 = new ConcurrentHashMap();
        map2.put("a", "b");

        Collections.synchronizedList(new ArrayList<>());

    }

    /**
     * 并发容器遍历过程中可以执行删除元素 操作，直接使用for就行了 但是不要使用迭代器操作
     *
     * 而且 不用使用 而且 在多线程情况下也不会出行问题
     */
    @Test
    public void test2() throws InterruptedException {
     /*   CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        for(int i=0;i<1000;i++){
            copyOnWriteArrayList.add("dome"+i);
        }*/
        /*copyOnWriteArrayList.forEach(o -> {
            if(o.equals("dome1")){
                copyOnWriteArrayList.remove(o);
            }
        });

        System.out.println(copyOnWriteArrayList.size());*/



     /*   for(int i=0;i<4;i++){
            new Thread(() -> {
                copyOnWriteArrayList.forEach(o -> {
                    if(o.equals("dome1")){
                        copyOnWriteArrayList.remove(o);
                    }
                });
            }).start();
        }
    */
        LinkedBlockingQueue linkedBlockingQueue=
                new LinkedBlockingQueue(7);
        linkedBlockingQueue.add("");//在队列满了的情况下会抛出异常
        linkedBlockingQueue.offer("");//在队列满了 级入队失败
        linkedBlockingQueue.put("");//在队列满了 会进入阻塞状态
        linkedBlockingQueue.remove();//在队列 空了的情况下会抛出异常
        linkedBlockingQueue.poll();//在队列空了 直接返回空
        linkedBlockingQueue.take();//在队列空了 会进入等待





    }
}
