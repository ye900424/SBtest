package thread.MyExe;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by C.A.O on 2018/6/9.
 */
public class BasicFuture {

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData()  {
        System.out.println("begin to start compute");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(1==1){
            throw new RuntimeException("手动抛出错误");
        }
        System.out.println("end to compute,passed " + (System.currentTimeMillis()-t));
        return rand.nextInt(1000);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Supplier<Integer> supplier = BasicFuture::getMoreData;

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(BasicFuture::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println("返回结果" + v);
            System.out.println("异常" + e);
        });
        System.out.println(f.get());
    }}