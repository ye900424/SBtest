package LockTest.SyncTest;

/**
 * Created by C.A.O on 2018/8/3.
 * synchronized关键字耗时测试
 */
public class SyncTimeTest {

    public static Integer count = 0;


    public static void main(String[] args) {
//        exe();
        syncExe();
    }

    public static void exe(){
        Long startTime = System.currentTimeMillis();
        // 累加到21亿
        while(count < Integer.MAX_VALUE){
            count = incr(count);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(count + "   "+ (endTime-startTime));
    }

    /**
     * 同步方法：对count+1
     * @param count
     * @return
     */
    public static synchronized Integer incrSync(int count){
        return  ++count;
    }

    public static Integer incr(int count){
        return  ++count;
    }




    /**
     * 同步方法：对count+1
     * @param count
     * @return
     */
    public static Integer incrWithSync(Integer count){
            count = count +1;
        return  count;
    }

    public static void syncExe(){

        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);



        Long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();
        System.out.println(count + "   "+ (endTime-startTime));

    }
}

class MyThread implements Runnable{
    public static Integer ticket = 10000000;
    public String threadName;

    public MyThread(){

    }

    public MyThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {


        System.out.println(Thread.currentThread().getName() + "    开始计算");

        synchronized (ticket){
            while(ticket > 0){
                ticket = ticket - 1;
                if(ticket % 50000 == 0){
                    System.out.println(Thread.currentThread().getName() + "    计算到" + ticket);
                }
                if(ticket == 0){
                    System.out.println(Thread.currentThread().getName() + "票卖光了");
                    break;
                }
            }
        }


        System.out.println(Thread.currentThread().getName() + "    结束计算");
    }
}
