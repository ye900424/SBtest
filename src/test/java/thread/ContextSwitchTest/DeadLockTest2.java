package thread.ContextSwitchTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by C.A.O on 2018/8/18.
 */
public class DeadLockTest2 {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        dlThread2 thread1 = new dlThread2(0,lock1,lock2);
        dlThread2 thread2 = new dlThread2(1,lock1,lock2);
        new Thread(thread1, "线程1").start();
        new Thread(thread2, "线程2").start();
    }
}

class dlThread2 implements Runnable {
    Lock lock1 ;
    Lock lock2 ;
    int flag = 0;

    public dlThread2(int flag, Lock lock1,Lock lock2) {
        this.flag = flag;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println(flag);

        if (flag == 0) {
            lock1.lock();
            try {
                Thread.sleep(1000);
                lock2.lock();
                System.out.println("get lock2");
                lock2.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            lock1.unlock();

        } else if (flag == 1) {
            lock2.lock();
            try {
                Thread.sleep(1000);
                lock1.lock();
                System.out.println("get lock1");
                lock1.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            lock2.unlock();
        }
    }
}
