package LockTest.SyncTest;

import com.model.Person;

/**
 * Created by C.A.O on 2017/12/28.
 */
public class Test {


    public static void main(String[] args) {
        Test test = new Test();
        test.test2();

    }

    // 测试锁对象
    public void test1() {
        LockFun lockFun = new LockFun();
        Thread thread_1 = new Thread(new SyncThread(1));
        Thread thread_2 = new Thread(new SyncThread(2));
        thread_1.start();
        thread_2.start();
    }

    // 测试锁类
    public void test2() {
        Thread thread_1 = new Thread(new SyncThread(4));
        Thread thread_2 = new Thread(new SyncThread(4));
        thread_1.start();
        thread_2.start();
    }

    class SyncThread implements Runnable {
        LockFun lockFun;
        Integer i = 0;

        public SyncThread(Integer i) {
            this.lockFun = new LockFun();
            lockFun.setPerson(new Person(System.currentTimeMillis()));
            this.i = i;
        }

        public SyncThread(LockFun lockFun, Integer i) {
            this.lockFun = lockFun;
            this.i = i;
        }

        @Override
        public void run() {
            switch (i) {
                case 1:
                    lockFun.fun1();
                    break;
                case 2:
                    lockFun.fun2();
                    break;
                case 3:
                    lockFun.fun3();
                    break;
                case 4:
                    lockFun.fun4();
                    break;
                default:
                    break;
            }
        }
    }
}
