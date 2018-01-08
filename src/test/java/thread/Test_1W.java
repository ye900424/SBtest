package thread;

/**
 * Author     :Administrator
 * Time       :17:31
 * Project    :CMSM
 * Package    :thread
 */
public class Test_1W {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("线程 : ");
        Thread thread1 = new Thread(myThread1, "a");
        Thread thread2 = new Thread(myThread1, "b");
        thread1.start();
        thread2.start();

//        MyThread2 myThread2 = new MyThread2();
//        myThread2.start();
    }
}

class MyThread implements Runnable {
    Count count = null;
    String str = "";

    public MyThread(String str) {
        this.str = str;
        count = new Count(str);
    }

    @Override
    public void run() {
//        for(int i = 0; i<1000000000 ;i++){
//            if(i%10000000 == 0){
//                System.out.println(str+i);
//            }
//        }

        count.fun(Thread.currentThread().getName());
    }
}

class Count {
    String str = "";
    int j = 1000000000;

    public Count(String str) {
        this.str = str;
    }

    public void fun(String name) {
        for (int i = 0; i < j; i++) {
            if (i % 10000000 == 0) {
                System.out.println(name + str + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        System.out.println("111111");
    }
}


