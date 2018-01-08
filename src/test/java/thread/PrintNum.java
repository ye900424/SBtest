package thread;

/**
 * Author     :Administrator
 * Time       :10:56
 * Project    :CMSM
 * Package    :thread
 */
public class PrintNum {
    private byte[] lock = new byte[0]; //自定义锁对象，这样代价最小，也可已使用当前对象this

    public void demo() {
        PrintThread a = new PrintThread("a");
//        PrintThread b = new PrintThread("b");
        a.start();
//        b.start();
    }

    class PrintThread extends Thread {

        public PrintThread(String name) {
            this.setName(name);
        }

        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 11; i++) {
                    if (i % 10 == 0 && 0 != i) {
                        try {
//                            Thread.sleep(1000);
                            System.out.println("+++++++++++++++++++++++++++++++++");
                            lock.notify(); //唤醒另外一个进程

                            lock.wait(); //暂时释放资源
                            System.out.println("thread："+this.getName()+"   被唤醒");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println(this.getName() + ": " + i + "是10 的倍数|||||||||||||||||||||||||");
                    }else{
                        System.out.println(this.getName() + ": " + i + "不是10 的倍数");
                    }
                }
            }
        }
    }
    public static void main(String sa[])
    {
        PrintNum n = new PrintNum();
        n.demo();


        System.out.println("main");
    }


    public static class fun extends Thread{

    }
}