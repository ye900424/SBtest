package thread;

/**
 * Author     :Administrator
 * Time       :11:34
 * Project    :CMSM
 * Package    :thread
 */
public class YieldTest extends Thread{
    public static void main(String[] args){
        Thread thread1 = new YieldTest("张三");
        Thread thread2 = new YieldTest("李四");
        thread1.start();
        thread2.start();
    }

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0;i<50;i++){
            System.out.println(Thread.currentThread().getName() + i);
            if(i == 30){
                Thread.yield();
            }
        }
    }
}



