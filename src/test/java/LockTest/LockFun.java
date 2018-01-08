package LockTest;

/**
 * Created by C.A.O on 2017/11/3.
 */
public class LockFun {

    private String ttt = "哈哈";

    public static void main(String args[]) {
        LockFun lockFun = new LockFun();
        lockFun.fun("1",1);
        lockFun.fun1();
    }

    private void fun(String s,Integer i) {
        synchronized (this) {
            System.out.println(1);
        }
    }

    public void fun2(String s,Integer i) {
        synchronized (this) {
            System.out.println(1111);
        }
    }

    public synchronized void fun1() {
        System.out.println(1);
    }

}
