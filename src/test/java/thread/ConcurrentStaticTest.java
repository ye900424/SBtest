package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Described：并发常量测试
 * @author YHJ create at 2013-04-17 下午08:54:24
 * @FileNmae com.yhj.jvm.memory.concurrent.ConcurrentStaticTest.java
 */
public class ConcurrentStaticTest {

    public static int counter  = 0;//volatile

    public final static int THRED_COUNT = 20;

    public static void plus() {
//        System.out.println(counter);
        counter++;
    }

    /**
     * @param args
     * @Author YHJ create at 2011-11-17 下午08:54:19
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<THRED_COUNT;++i){
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    for(int j = 0;j<10;++j){
                        plus();
                    }
                }

            });
        }

//        executorService.shutdown();
        //等待所有进程结束
        while(Thread.activeCount()>1){
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println("0");
        System.out.println(counter+"------------------------------");

    }
}