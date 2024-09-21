package bs2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Foo {
    public void first() {
        System.out.println("first");
    }

    public void second() {
        System.out.println("second");
    }

    public void third() {
        System.out.println("third");
    }

    public static volatile Integer num = 0;
    public static Object lock = new Object();

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Foo instance = new Foo();
        instance.doAction(new int[]{1, 3, 2});
    }

    public void doAction(int[] nums) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        if (list.contains(1)) {
            executor.submit(() -> {
                while (num == 0) {
                    synchronized (lock) {
                        num++;
                        first();
                        lock.notifyAll();
                    }
                }
            });
        }

        if (list.contains(2)) {
            executor.submit(() -> {
                while (num == 1) {
                    synchronized (lock) {
                        second();
                        num++;
                        lock.notifyAll();
                    }
                }
            });
        }


        if (list.contains(3)) {
            executor.submit(() -> {
                while (num == 2) {
                    synchronized (lock) {
                        third();
                        num++;
                        lock.notifyAll();
                    }
                }
            }).get(100L, TimeUnit.MILLISECONDS);
        }

        executor.shutdown();


    }
}
