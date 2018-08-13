package LockTest.ReentrantlockTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by C.A.O on 2018/7/8.
 */
public class Test {
    private ReentrantLock lock = new ReentrantLock(true);

    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws NoSuchFieldException {
        Test test = new Test();
//        CompletableFuture future = CompletableFuture.supplyAsync(() -> test.fun());
//        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> test.fun1());

        CompletableFuture future = CompletableFuture.supplyAsync(() -> test.funLock(),executor);
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> test.funLock1(),executor);

        CompletableFuture.allOf(future1,future).join();


        executor.shutdown();
    }


    public String funLock() {
        System.out.println(Thread.currentThread());
        lock.lock();
        System.out.println("funLock 获得锁，开始睡眠");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            System.out.println("funLock被中断。");
            e.printStackTrace();
        }
        System.out.println("do funLock~");
        lock.unlock();

        return "";
    }

    public String funLock1() {
        System.out.println(Thread.currentThread());
        lock.lock();
        System.out.println("funLock1 获得锁");
        System.out.println("do funLock1~");
        lock.unlock();

        return "";
    }


    public String fun() {
        System.out.println(Thread.currentThread());
        if (lock.tryLock()) {
            try {
                Test test = new Test();
                test.fun1();
                Thread.sleep(50000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do something~");
            lock.unlock();
        } else {
            System.out.println("方法fun() 没有获得锁，并未执行");
            return "";
        }


        return "";
    }

    public String fun1() {
        System.out.println(Thread.currentThread());
        try {
            if (lock.tryLock()) {
                System.out.println("do something2~");
                lock.unlock();
            } else {
                System.out.println("方法fun1() 没有获得锁，并未执行");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
