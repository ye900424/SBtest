package thread;

/**
 * Author     :Administrator
 * Time       :16:31
 * Project    :CMSM
 * Package    :thread
 */
public class TestWait {
    public static void main(String[] args) {
        Queue q = new Queue();// 创建一个信箱
        Producer p = new Producer(q);// 创建一个放情报线程，需要一个信箱的对象作为参数
        Consumer c = new Consumer(q);// 创建一个取情报线程，需要一个信箱的对象作为参数
        p.start();// 启动线程
        c.start();// 启动线程
    }
}

class Producer extends Thread {
    Queue q;

    Producer(Queue q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            q.put(i);

        }
    }
}

class Consumer extends Thread// 我们设一次只放一个数据
{
    Queue q;

    Consumer(Queue q) {
        this.q = q;
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

class Queue {
    int value;
    boolean bFull = false;// 设一个Boolean变量标志信箱中是否有情报

    public synchronized void put(int i) {// 这里需要用同步的方法否则可能放到一半中断
        if (bFull == false) {// 如果信箱中没有情报放情报并将bFull设置成true，然后用notify()方法通知另一个情报员线程取情报
            value = i;
            bFull = true;
            System.out.println("Producer put " + i);//这里是修改的
            notify();
        }
        try {// 可能开始已经有情报，这时候执行wait()方法等待
            wait();// 该方法会跑出异常需要捕获
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized int get() {// 这里需要用同步的方法否则可能取到一半中断
        if (bFull == false) {// 如果没有情报调用wait()方法等待
            try {
                wait();// 该方法会跑出异常需要捕获
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        bFull = false;// 如果有情报，将bFull设置成false，并用notify()方法通知另外一个情报员线程，然后返回情报数据
        System.out.println("Consumer get " + value);//这里是修改的
        notify();
        return value;
    }
}