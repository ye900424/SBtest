package bs2024.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Print1_2 {

    public static volatile int num = 1;
    public static void main(String[] args) {
        Print1_2 instance = new Print1_2();
        instance.foo();

    }

    public void foo(){
        Object lock = new Object();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        executor.submit(()->{
            while(num<=10){
                synchronized (lock){
                    if((num&1) == 1){
                        System.out.println(num);
                        num++;
                    }
                    lock.notifyAll();
                }
            }
        });

        executor.submit(()->{
            while(num<=10){
                synchronized (lock){
                    if((num&1) == 0){
                        System.out.println(num);
                        num++;
                    }
                    lock.notifyAll();
                }
            }
        });
    }


}
