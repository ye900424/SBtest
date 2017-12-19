package threadpool.ThreadPollExeTest;

import java.util.concurrent.*;

/**
 * Created by C.A.O on 2017/12/8.
 */
public class Test {
    public static void main(String[] args){
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,3,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,3,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1),new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i = 0 ; i< 100;i++){
            System.out.println(i + "biaoji");
            Worker worker = new Worker("thread"+i);
            threadPoolExecutor.execute(worker);

            Executors.defaultThreadFactory();
        }




//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println( "线程运行中");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Callable<Integer> callable = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                Thread.sleep(500);
//                return 1;
//            }
//        };
//
//        threadPoolExecutor.execute(runnable);
//        Future futureTask = threadPoolExecutor.submit(callable);
//        while(true){
//            if(futureTask.isDone()){
//                try {
//                    System.out.println("callable结果"+futureTask.get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//                return;
//            }
//            System.out.println("futureTask.isDone() == false");
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        FutureTask<Integer> futureTask = threadPoolExecutor.submit(callable);






//        while(true){
//            if(threadPoolExecutor.getActiveCount() == 0){
//                threadPoolExecutor.shutdown();
//                return;
//            }
//            System.out.println("当前线程数："+threadPoolExecutor.getActiveCount());
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
