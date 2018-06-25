package thread.MyExe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by C.A.O on 2018/5/31.
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,13,44,55,78,99,99);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取

        Supplier supplier = () -> calc(1,2);



        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync((Supplier<Integer>)() -> calc(integer,integer), executorService)
                        .thenApply(h->Integer.toString(h+100))
                        .whenComplete((s, e) -> {
                            System.out.println("任务"+s+"完成!result="+s+"，异常 e="+e+","+new Date());
                            list.add(s);
                        })
                ).toArray(CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(cfs).join();
        System.out.println("list="+list+",耗时="+(System.currentTimeMillis()-start));


        System.out.println("______________________________");

        process();

    }

    public static Integer calc(Integer i,Integer l) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }


    public static List<String> process() {

        List<String> messages = Arrays.asList("Msg1", "Msg2", "Msg3", "Msg4", "Msg5", "Msg6", "Msg7", "Msg8", "Msg9",
                "Msg10", "Msg11", "Msg12");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<String> mapResult = new ArrayList<>();

        CompletableFuture<?>[] fanoutRequestList = new CompletableFuture[messages.size()];
        int count = 0;
        for (String msg : messages) {
            CompletableFuture<?> future = CompletableFuture
                    .supplyAsync(() -> sendMsg(msg), executor).exceptionally(ex -> "Error")
                    .thenAccept(mapResult::add);

            fanoutRequestList[count++] = future;
        }

        try {
            CompletableFuture.allOf(fanoutRequestList).get();
            //CompletableFuture.allOf(fanoutRequestList).join();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mapResult.stream().filter(s -> !s.equalsIgnoreCase("Error")).collect(Collectors.toList());
    }

    public static String sendMsg(String message){

        return "ok";
    }
}
