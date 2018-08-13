package thread.InterrupteTest;

/**
 * Created by C.A.O on 2018/7/23.
 */
public class Test {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread1.interrupt();

    }
}

class MyThread extends Thread{
    Integer i = 0;

    @Override
    public synchronized void run() {
        while(i < 100){
            System.out.println(i++);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("中断");
                e.printStackTrace();
            }
        }
    }


}
