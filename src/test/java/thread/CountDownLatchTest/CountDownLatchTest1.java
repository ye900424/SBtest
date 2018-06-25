package thread.CountDownLatchTest;

import model.Person;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {

    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;
    public static void main(String[] args) {

        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);

            // 新建5个任务
            for(int i=0; i<LATCH_SIZE; i++)
                new InnerThread().start();

            System.out.println("main await begin.");

            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();

            System.out.println("main await finished.");


            doneSignal = new CountDownLatch(2);
            Person person = new Person(6639l,"老曹");
            new BeanThread(person,"陈龙",null).start();
            new BeanThread(person,"老234",123).start();
            new BeanThread(person,"老234",122223).start();
            doneSignal.await();

            System.out.printf(person.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
//                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class BeanThread extends Thread{
        private Person person;
        private String name;
        private Integer sex;

        public BeanThread(Person person,String name,Integer sex){
            this.person = person;
            this.name = name;
            this.sex = sex;
        }

        public void run() {
            try {
                if(null != name) person.setName(name);
                if(null != sex) person.setSex(sex);

                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}