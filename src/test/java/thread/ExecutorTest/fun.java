package thread.ExecutorTest;



import java.util.concurrent.*;

/**
 * Author     :Administrator
 * Time       :15:12
 * Project    :CMSM
 * Package    :thread.ExecutorTest
 */
public class fun {
    private static ExecutorService executor = Executors.newFixedThreadPool(2);


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        executor.submit(new RunableTest());
        Future<MyBean> result = executor.submit(new CallableTest());
        result.get();
        System.out.println("future.get数据："+result.get());

//        FutureTask<MyBean> futureTask = new FutureTask<MyBean>(new CallableTest());

//        executor.submit(new RunableTest(),new CallableTest());
        executor.shutdown();
    }
}


class CallableTest implements Callable<MyBean>{

    @Override
    public MyBean call() throws Exception {
        MyBean1 myBean1 = new MyBean1("bean1第一个参数","bean1第二个参数");
        MyBean myBean = new MyBean("bean第一个参数","bean第二个参数","bean第三个参数","bean第四个参数",myBean1);
//        System.out.println(myBean.toString());
        return myBean;
    }
}

class RunableTest implements Runnable{
    int tickets = 5 ;

    @Override
    public void run() {
        for(int i = 0;i < 10 ; i++){
            if(tickets > 0){
                System.out.println("剩余票数哈哈哈"+tickets);
                tickets--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
