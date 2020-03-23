package LockTest.SyncTest;

import com.model.Person;

/**
 * Created by C.A.O on 2017/11/3.
 * Synchronized 锁的是对象
 */
public class LockFun {

    private static String ttt = "哈哈";
    public String ppp = "哈哈";
    public static Person person = new Person();

    public void setPerson(Person person){
        this.person = person;
    }

    public static void main(String args[]) {
        LockFun lockFun = new LockFun();
        lockFun.fun2();
        lockFun.fun1();
    }

    public void fun2() {
        synchronized (this) {
            System.out.println("fun2 方法开始");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fun2 方法结束");
            System.out.println();
            System.out.println();
        }
    }



    public synchronized void fun1() {
        System.out.println("fun1 方法开始");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fun1 方法结束");
        System.out.println();
        System.out.println();
    }

    public synchronized static void fun3() {
        System.out.println("fun3 静态方法开始");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fun3 静态方法结束");
        System.out.println();
        System.out.println();
    }

    public void fun4() {
        synchronized (person){
            System.out.println("fun4 方法开始");
            System.out.println(person.toString());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fun4 方法结束");
            System.out.println();
            System.out.println();
        }
    }

}
