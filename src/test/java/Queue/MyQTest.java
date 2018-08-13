package Queue;

import lombok.Data;

import java.util.concurrent.*;

/**
 * Created by C.A.O on 2018/8/5.
 */
public class MyQTest {
    public static void main(String[] args) {
        Producer.produce();
        Consumer.consume();
    }
}

/**
 * 工作队列
 */
class WorkQueue {
    // 50大小的队列
    public static BlockingQueue<Work> workQueue = new ArrayBlockingQueue<Work>(5);
    public static BlockingQueue<Work> workQueue1 = new LinkedBlockingQueue<>(5);

    // 出队列（阻塞）
    public static Work take() {
        Work work = null;
        try {
            work = workQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return work;
    }

    public static Work poll() {
        return workQueue.poll();
    }

    public static Work poll(int i, TimeUnit timeUnit) {

        System.out.println(workQueue.size());
        try {
            return workQueue.poll(i, timeUnit);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "等待超时啦");
            e.printStackTrace();
        }
        return null;
    }


    // 入队
    public static boolean pull(Work work) {
        return workQueue.offer(work);
    }

    public static boolean add(Work work) {
        return workQueue.add(work);
    }

    public static void put(Work work) {
        try {
            workQueue.put(work);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 工作
 */
@Data
class Work {
    private int id;
    private String name;

    public Work(int id) {
        this.id = id;
        this.name = id + "号任务";
    }

    public void proWork(String name) {
        try {
            System.out.println("正在生产" + name);
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void csuWork(String name) {
        try {
            System.out.println("正在处理" + name);
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者
 * 每隔5秒生产一个work
 */
class Producer {
    public static int workCount = 0;

    /**
     * 生产动作
     */
    public static void produce() {
        ScheduledThreadPoolExecutor produceStp = new ScheduledThreadPoolExecutor(2);
        produceStp.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (workCount == 20) return;
                try {
                    workCount++;
                    Work work = new Work(workCount);
                    work.proWork(work.getName());
                    WorkQueue.put(work);
                    System.out.println(Thread.currentThread().getName() + "         成功生产 " + workCount + " 号任务");
                } catch (Exception e) {
                    System.out.println("生产任务失败  " + e.getStackTrace());
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

}

/**
 * 消费者
 * 每隔10秒处理一个work
 */
class Consumer {

    /**
     * 消费动作
     */
    public static void consume() {
        ScheduledThreadPoolExecutor stp = new ScheduledThreadPoolExecutor(5);
        stp.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Work work = WorkQueue.poll(3,TimeUnit.SECONDS);
//                    Work work = WorkQueue.take();
                    if (null != work) {
                        System.out.println(Thread.currentThread().getName() + " 领取到工作 " + work.getName());
                        work.csuWork(work.getName());
                    } else {
                        System.out.println("没有任务领取");
                    }
                } catch (Exception e) {
                    System.out.println("任务领取失败  " + e.getStackTrace());
                }

            }
        }, 5, 1, TimeUnit.SECONDS);

    }
}
