import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 半成品
 *
 * @author C.A.O
 * @date 2020/2/28
 */
public class ZeroEvenOdd2 {

    static AtomicInteger num = new AtomicInteger();
    static AtomicBoolean tag = new AtomicBoolean(true);

    static int max = 100;
    public static void main(String[] args) {

        ExecutorService services = Executors.newFixedThreadPool(3);

        services.execute(() -> {
            while(num.get()<=max ){
                while(tag.get()){
                    System.out.println("thread0__ "+ 0);
                    tag.set(!tag.get());
                    if(num.get() == 0){
                        num.incrementAndGet();
                    }
                }
            }
        });

        services.execute(() -> {
            while(num.get()<=max ){
                while(!tag.get() && (num.get() & 1) == 0){ //奇数
                    System.out.println("thread1__ "+ num.get());
                    num.incrementAndGet();
                    tag.set(!tag.get());
                }
            }
        });

        services.execute(() -> {
            while(num.get()<=max ){
                while(!tag.get() && (num.get() & 1) != 0){ //奇数
                    System.out.println("thread2__ "+ num.get());
                    num.incrementAndGet();
                    tag.set(!tag.get());
                }
            }
        });


    }
}
