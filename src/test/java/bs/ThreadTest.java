package bs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author C.A.O
 * @date 2020/1/7
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.fun1();
    }

    public void fun1() {
        final AtomicInteger count = new AtomicInteger(0);
        final AtomicBoolean b = new AtomicBoolean(false);


        new Thread(() -> {
            while (count.get() < 100) {
                synchronized (count) {
                    if (b.getAndSet(false)) {
                        System.out.println(Thread.currentThread().getName() + "     " + count.getAndAdd(1));

                        count.notifyAll();
                    } else {
                        try {
                            count.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        }, "thread1").start();

        new Thread(() -> {
            while (count.get() < 100) {
                synchronized (count) {
                    if (!b.getAndSet(true)) {
                        System.out.println(Thread.currentThread().getName() + "     " + count.getAndAdd(1));
                        b.set(true);

                        count.notifyAll();
                    } else {
                        try {
                            count.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }, "thread2").start();
    }


    public void fun2(){
        // todo 线程excutor使用

        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newScheduledThreadPool(2);
        Executors.newCachedThreadPool();






    }

}
