package threadpool.ThreadPollExeTest;

/**
 * Created by C.A.O on 2017/12/8.
 */
public class Worker implements Runnable{
    private String workerName = "thread1";

    public Worker(){}

    public Worker(String workerName){
        this.workerName =workerName;
    }


    @Override
    public void run() {
        try {
            System.out.println(workerName+" is runing");
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
