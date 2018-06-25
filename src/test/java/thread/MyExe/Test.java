package thread.MyExe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by C.A.O on 2018/5/29.
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // todo get时要补获异常
        /*MyExecuter myExecuter = new MyExecuter();
        System.out.printf("fun结果 :" + myExecuter.exeTask1(new MyCallable("Test_S","fun","18112","996639")).get());

        Person person = new Person(111l,"laocao");

        Person person1 = (Person) myExecuter.exeTask1(new MyCallable("Test_S","happy",person)).get();
        System.out.printf("happy结果 :" + person1.toString());

        for(int i = 0 ; i < 50 ;i++){
            myExecuter.exeTask(new MyCallable("thread.MyExe.Test","fun","任务"+i));
        }
        myExecuter.await();

        System.out.println("##########VOER##########");*/

        MyExecuter myExecuter = new MyExecuter();
        AsyncExecutor asyncExecutor = new AsyncExecutor();
        Test test = new Test();
        System.out.println("开始任务");
//        Future f = myExecuter.exeTask0(() -> test.fun("lalalalal"));
        Future f = asyncExecutor.add("test",() -> test.fun("111111111"));
        Future f2 = asyncExecutor.add("test",() -> test.fun2("222222222"));

        CompletableFuture completableFuture = asyncExecutor.isFinished();
        completableFuture.join();

        System.out.println("任务结束");
//        System.out.println("任务结束"+f.get());
//        asyncExecutor.isFinished();
    }


    public String fun(String taskName){

        try {

            Thread.sleep(1000l);

            System.out.println("执行任务"+taskName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(1 == 1){
            throw new RuntimeException("1234");
        }
        return taskName;
    }

    public String fun2(String taskName){

        try {

            Thread.sleep(3000l);

            System.out.println("执行任务"+taskName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(1 == 1){
            throw new RuntimeException("1234");
        }
        return taskName;
    }
}
