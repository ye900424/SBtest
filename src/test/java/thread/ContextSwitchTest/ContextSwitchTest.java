package thread.ContextSwitchTest;

/**
 * Author     :Administrator
 * Time       :14:39
 * Project    :CMSM
 * Package    :thread.ContextSwitchTest
 */
public class ContextSwitchTest {
    private final static long count = 1000000000l;


    public static void main(String[] args) throws InterruptedException {
        fun1();
        fun2();
        fun3();
    }

    public static void fun1() throws InterruptedException {
        Long time1 = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
                System.out.println(a);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b--;
                }
                System.out.println(b);

            }
        });
        thread2.start();





        thread1.join();
        thread2.join();
        Long time2 = System.currentTimeMillis();
        System.out.println("启动两个thread耗时：" + (time2 - time1) + "ms");
    }

    public static void fun2() throws InterruptedException {
        Long time1 = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                int b = 0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
                for (int i = 0; i < count; i++) {
                    b--;
                }
                System.out.println(a);
                System.out.println(b);
            }
        });
        thread.start();
        thread.join();
        Long time2 = System.currentTimeMillis();
        System.out.println("启动一个thread耗时：" + (time2 - time1)+"ms");
    }


    public static void fun3() {
        Long time1 = System.currentTimeMillis();

        int a = 0;
        int b = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        for (int i = 0; i < count; i++) {
            b--;
        }
        Long time2 = System.currentTimeMillis();
        System.out.println("不重启线程，走主程序耗时：" + (time2 - time1)+ "ms, b = " + b + ", a = " + a);
    }
}
