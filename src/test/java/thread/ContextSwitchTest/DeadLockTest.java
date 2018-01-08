package thread.ContextSwitchTest;

/**
 * Author     :Administrator
 * Time       :17:10
 * Project    :CMSM
 * Package    :thread.ContextSwitchTest
 */
public class DeadLockTest {
    public static void main(String[] args) {
        dlThread thread1 = new dlThread(0);
        dlThread thread2 = new dlThread(1);
        new Thread(thread1,"线程1").start();
        new Thread(thread2,"线程1").start();
    }
}

class dlThread implements Runnable{
    static Object o1 = new Object();
    static Object o2 = new Object();
    int flag = 0;



    public dlThread(int flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(flag);

        if(flag == 0){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                    synchronized (o2){}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }else if(flag == 1){
            synchronized (o2){
                try {

                    Thread.sleep(1000);
                    synchronized (o1){}

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}


