package LockTest;

/**
 * Created by C.A.O on 2017/11/3.
 */
public class LockFun {

    public static void main(String args[]) {
        LockFun lockFun = new LockFun();
        lockFun.fun();
        lockFun.fun1();
    }

    public void fun() {
        synchronized (this) {
            System.out.println(1);
        }
    }

    public synchronized void fun1() {
        System.out.println(1);
    }

}
