package com.chenxy.currentPackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chxy
 * @date 2019/2/13 2:59 PM
 */
public class DeadLock implements Runnable {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public DeadLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1){
                lock1.lockInterruptibly();

                // 同样可以避免死锁
                lock1.tryLock(1, TimeUnit.SECONDS);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                lock2.lockInterruptibly();

            }else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){}
                lock1.lockInterruptibly();

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread())
                lock1.unlock();
            if (lock2.isHeldByCurrentThread())
                lock2.unlock();
            System.out.println(Thread.currentThread().getId() + "线程中断");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock1 = new DeadLock(1);
        DeadLock deadLock2 = new DeadLock(2);
        // 线程1, 线程2分别去获取lock1, lock2. 导致死锁
        Thread t1 = new Thread(deadLock1);
        Thread t2 = new Thread(deadLock2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 死锁检查, 触发中断
        //DeadlockChecker.check();

    }
}
