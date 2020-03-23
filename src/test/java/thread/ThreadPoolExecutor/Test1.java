package thread.ThreadPoolExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author C.A.O
 * @date 2019/8/21
 */
public class Test1 {

    public static void main(String[] args) {
        ScheduledExecutorService respScheduler = new ScheduledThreadPoolExecutor(2);
        System.out.println("task begin:"+System.currentTimeMillis()/1000);
        respScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);//2000
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--task run:"+System.currentTimeMillis()/1000);
            }
        },2,3, TimeUnit.SECONDS);}

}
