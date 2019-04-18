package com.chenxy.notify;

/**
 * @author chxy
 * @date 2019/1/30 11:44 AM
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin "
                            + System.currentTimeMillis());
                    //lock.wait();
                    Thread.sleep(3000);
                    System.out.println("wait end  "
                            + System.currentTimeMillis());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
