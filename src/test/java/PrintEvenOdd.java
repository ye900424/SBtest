import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 奇偶交替打印
 *
 * @author C.A.O
 * @date 2020/2/14
 */
public class PrintEvenOdd {

    // 共享变量
    public static int count = 0;

    public static int max = 100;


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        // 偶数线程
        Thread evenThread = new Thread(() -> {
            while (count < max) {
                lock.lock();
                while ((count & 1) == 0) {
                    // 当前数为偶数，释放锁等待
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印偶数
                System.out.println("偶数线程：" + ++count);
                condition.signalAll();
                lock.unlock();
            }
        });

        Thread oddThread = new Thread(() -> {
            while (count < max) {
                lock.lock();
                while ((count & 1) == 1) {
                    // 当前数为奇数，释放锁等待
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印奇数
                System.out.println("奇数线程：" + ++count);
                condition.signalAll();
                lock.unlock();
            }
        });

        evenThread.start();
        oddThread.start();
    }


}
