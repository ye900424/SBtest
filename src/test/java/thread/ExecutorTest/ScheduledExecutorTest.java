package thread.ExecutorTest;

import thread.MyExe.NamedThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author C.A.O
 * @date 2019/5/29
 */
public class ScheduledExecutorTest {

    private static final int TIMEOUT_CHECK_INTERNAL = 3000;


    public static void main(String[] args) {
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1,
                new NamedThreadFactory("timeoutChecker"));

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈哈" + System.currentTimeMillis());


            }
        },TIMEOUT_CHECK_INTERNAL,TIMEOUT_CHECK_INTERNAL, TimeUnit.MILLISECONDS);
    }

    public void fun(){

    }
}
