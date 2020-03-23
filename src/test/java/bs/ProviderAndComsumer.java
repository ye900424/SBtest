package bs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author C.A.O
 * @date 2020/1/9
 */
public class ProviderAndComsumer {
    public static void main(String[] args) throws InterruptedException {
        String preThing = "任务";
        AtomicInteger count = new AtomicInteger(0);

        ExecutorService provider = Executors.newFixedThreadPool(5,new NameThreadFactory("生产者"));
        ExecutorService comsumer = Executors.newFixedThreadPool(3,new NameThreadFactory("消费者"));



        for(int i = 0 ;i < 3; i++){
            provider.execute(() -> {
                while (true) {
                    Provider.provide(preThing + count.addAndGet(1));
                }
            });

            comsumer.execute(()->{
                while (true) {
                    Consumer.comsume();
                }
            });
        }


    }


}

class NameThreadFactory implements ThreadFactory{

    private String preName;
    private Integer count = 0;

    public NameThreadFactory(String preName){
        this.preName = preName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,preName+count++);
    }
}



class Store{
    LinkedBlockingQueue<Work> queue = new LinkedBlockingQueue<>(5);

    private static volatile Store instance = null;

    private Store(){}

    public static Store getInstance(){
        if(instance == null){
            synchronized (Store.class){
                if(instance == null){
                    instance = new Store();
                }
            }
        }
        return instance;
    }



    public  void offer(Work work) throws InterruptedException {
        queue.put(work);
    }

    public  Work take() throws InterruptedException {
        return queue.take();
    }
}

class Consumer{
    public static void comsume(){
        try {
            Store.getInstance().take().doSomeThing();
//            System.out.println("            消费一个任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Provider{
    public static void provide(String thing) {
        Work work = new Work(thing);
        try {
            Store.getInstance().offer(work);
            System.out.println("生产"+thing);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Work{
    public String thing;

    public void doSomeThing(){
        System.out.println("消费"+thing);
    }

    public Work(String thing){
     this.thing = thing;
    }
}
