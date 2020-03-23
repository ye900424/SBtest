package bs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author C.A.O
 * @date 2020/2/4
 */
class ZeroEvenOdd {
    private int n;
    // 被争夺的共享变量
    volatile boolean printZero = true;
    volatile int count = 0;

    ReentrantLock lock0 = new ReentrantLock();
    Condition condition0 = lock0.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock0.lock();
            while (!printZero) {
                condition0.await();
            }
            printNumber.accept(0);
            printZero = !printZero;
            condition0.signalAll();
            lock0.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n ; i+=2){
            lock0.lock();
            while((count & 1) == 0 || printZero){
                condition0.await();
            }
            printNumber.accept(++count);
            printZero = !printZero;
            condition0.signalAll();
            lock0.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n ; i+=2){
            lock0.lock();
            while((count & 1) == 1 || printZero){
                condition0.await();
            }
            printNumber.accept(++count);
            printZero = !printZero;
            condition0.signalAll();
            lock0.unlock();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(9);

        IntConsumer intConsumer = new IntConsumer();
        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class IntConsumer {
    void accept(int x) {
        System.out.println(x);
    }
}
