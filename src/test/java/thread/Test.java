package thread;

/**
 * Author     :Administrator
 * Time       :16:56
 * Project    :CMSM
 * Package    :thread
 */
class TicketSouce implements Runnable {
    //票的总数
    private Integer  ticket = 10;

    public void run() {
        for (int i = 1; i < 20; i++) {
             try {
                //休眠1s秒中，为了使效果更明显，否则可能出不了效果
                Thread.sleep(1);
                this.sale();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sale() {
        synchronized (this){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "号窗口卖出" + this.ticket-- + "号票");
            }
        }
    }

    public  void sale1(String name) {
        if (ticket > 0) {
            System.out.println(name + "号窗口卖出" + this.ticket-- + "号票");
        }
    }
}

public class Test {
    public static void main(String args[]) {


        TicketSouce mt = new TicketSouce();
//        TicketSouce mt1 = new TicketSouce();
//        TicketSouce mt2 = new TicketSouce();
        //基于火车票创建三个窗口
        new Thread(mt, "a").start();
        new Thread(mt, "b").start();

        //睡眠的是main主线程
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        new Thread(mt, "c").start();
        System.out.println("main在此");



    }

}
