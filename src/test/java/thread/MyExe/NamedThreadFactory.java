package thread.MyExe;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by C.A.O on 2018/5/29.
 */
public class NamedThreadFactory implements ThreadFactory{
    private AtomicInteger count = new AtomicInteger(0);

    private String threadName = "default-thread";

    @Override
    public Thread newThread(Runnable r) {
//        Thread thread = new Thread(r,"测试线程组"+count.incrementAndGet());
        Thread thread = new Thread(r,threadName);
        return thread;
    }

    public NamedThreadFactory(String threadName){
        this.threadName = threadName;
    }

    public NamedThreadFactory(){

    }
}
