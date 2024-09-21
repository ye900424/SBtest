package bs2024.thread;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.quartz.spi.ThreadExecutor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,100L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));
//
//        executor.execute(()->{
//            System.out.println(123);
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate (()-> System.out.printf("1"),1L,1L,TimeUnit.SECONDS);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,100L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));



    }
}
