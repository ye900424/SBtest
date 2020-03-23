package bs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author C.A.O
 * @date 2020/1/9
 */
public class Deadlock {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Boolean tag = false;

        executorService.execute(() -> {
            lock1.lock();
            System.out.println("使用资源1，等待资源2的锁");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock2.lock();
            System.out.println("使用资源2");
        });

        executorService.execute(() -> {
            lock2.lock();
            System.out.println("使用资源2，等待资源1的锁");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock1.lock();
            System.out.println("使用资源2");
        });


    }
}
