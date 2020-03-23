package LockTest.SyncTest;

/**
 * Created by C.A.O on 2018/8/18.
 */
public class FuleiTest {

    public static void main(String[] args) {
        FuleiTest fuleiTest = new FuleiTest();
        SubClass subClass = new SubClass();


        Thread thread_1 = new Thread(() ->{subClass.doSub();});
        Thread thread_2 = new Thread(() ->{subClass.doSub();});

        thread_1.start();
        thread_2.start();

        subClass.doPar();

        try {
            thread_1.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SubClass extends ParClass{
    public synchronized void doSub(){
        doPar();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("子类搞事情");
    }
}

class ParClass{
    public synchronized void doPar(){
        System.out.println("父类搞事情");
    }
}