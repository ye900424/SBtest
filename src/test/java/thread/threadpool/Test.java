package thread.threadpool;

/**
 * Author     :Administrator
 * Time       :16:58
 * Project    :CMSM
 * Package    :thread.threadpool
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试类,测试功能如下：
 * 1、测试线程池创建功能
 * 2、测试处理并发请求功能
 * 3、测试关闭功能
 **/
public class Test {
    public static void main(String[] args){

        CountDownLatch countDownLatch = new CountDownLatch(10);

//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue();


        Test.fun();

//        //创建线程池,开启处理请求服务
//        final int threadCount=10;
//        PoolManage pool=PoolManage.getInstance();
//        pool.init();
//        //接收客户端请求
//        WorkTask task1=new  WorkTaskAImp("执行超时任务1...");
//        TaskManager.addTask(task1);
//        final int requestCount=15;
//        for(int i=0;i<requestCount;i++){
//            WorkTask task=new WorkTaskImp("执行第"+i+"个增加用户操作.....");
//            TaskManager.addTask(task);
//        }
        /**/


    }





    public static void fun(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);

//        executorService.submit(() -> {
//            Object obj = null;
//            System.out.println(obj.toString());
//        });

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        executorService.execute(() -> {
            Object obj = null;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(obj.toString());
        });




    }
}
