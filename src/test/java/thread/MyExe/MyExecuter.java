package thread.MyExe;

import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by C.A.O on 2018/5/29.
 */
@NoArgsConstructor
public class MyExecuter<T,R> {
    //todo 手动建立，制定大小的队列，监控队列，超出大小报警
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new NamedThreadFactory());

    private List<FutureTask> futureList = new ArrayList<>();
    private List<Future> futures = new ArrayList<>();


    public Future exeTask(T t, Consumer consumer){
        Future future = executorService.submit(() -> consumer.accept(t));
        futures.add(future);
        return future;
    }


    public Future exeTask0(Supplier<R> supplier) {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(supplier,executorService);

        completableFuture.whenComplete((v,e) -> {
            if(null != e)
                System.out.println(e);
        });
        return completableFuture;
    }

    public FutureTask exeTask1(MyCallable task) {
        System.out.println(task.getClassName()+"."+task.getMethodName() + task.getArgs());
        return this.exeTask(task);
    }


    public FutureTask exeTask(Callable task) {
        FutureTask future = null;
        try {
            future = (FutureTask) executorService.submit(task);
//
        } catch (Exception e) {
            System.out.println("stack打印"+e.getStackTrace());
            throw e;
        }
        futureList.add(future);
        return future;
    }

    public boolean await() {

        futureList.forEach(futureTask -> {
            try {
                futureTask.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        return true;
    }

    @PostConstruct
    public void init() {
        System.out.println("########init");
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new NamedThreadFactory());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("########destroy");
        if (null != executorService) {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        MyExecuter myExecuter = new MyExecuter();
        for (int i = 0; i < 100; i++) {
            myExecuter.exeTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(500l);
                    System.out.println("执行任务中" + Math.random());
                    return null;
                }
            });
        }
    }

}
