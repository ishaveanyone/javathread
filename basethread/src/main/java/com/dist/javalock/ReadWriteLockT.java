package com.dist.javalock;


import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 *
 * 读写锁
 * Created by Administrator on 2019/5/16.
 */
public class ReadWriteLockT {

//    jdk 1.6 中使用 ReadWriteLock
   static ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
   static ReentrantReadWriteLock.ReadLock rlock=rwlock.readLock();
   static ReentrantReadWriteLock.WriteLock wlock=rwlock.writeLock();

   private static   double   x,y;

   static StampedLock stampedLock =new StampedLock();

   private static Map<String, Object> data = new HashMap<>();


   public static Object get(String key) {
      rlock.lock();
      try {
         return data.get(key);
      } finally {
         rlock.unlock();
      }
   }

   public static Object put(String key, Object value) {
      wlock.lock();
      try {
         return data.put(key, value);
      } finally {
         wlock.unlock();
      }
   }


//    jdk 1.8 中使用 StampedLock

   public static void add() {
     long stamp= stampedLock.writeLock();
      try {
         x++;
         y++;
      }catch (Exception e){
         e.printStackTrace();
      }finally {
         stampedLock.unlockWrite(stamp);
      }
   }

   public static void read() {
      //这个是乐观读锁
      long stamp= stampedLock.tryOptimisticRead();
      try {
         System.out.println(x);
         System.out.println(y);
      }catch (Exception e){
         e.printStackTrace();
      }finally {
         stampedLock.unlockRead(stamp);
      }
   }






   public static void main(String[] args) {

   }


}
