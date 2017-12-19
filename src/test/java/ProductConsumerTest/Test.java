package ProductConsumerTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author     :Administrator
 * Time       :15:29
 * Project    :CMSM
 * Package    :thread.ProductConsumerTest
 */
public class Test {
    public static void main(String[] args) {
        Test pc = new Test();

        Storage s = new Storage();

        ExecutorService service = Executors.newCachedThreadPool();
        Producter p = new Producter("P_1", s ,10l);
        Producter p2 = new Producter("P_2", s ,10l);

        Consumer c = new Consumer("C_1", s);
        Consumer c2 = new Consumer("C_2", s);
        Consumer c3 = new Consumer("C_3", s);
        Consumer c4 = new Consumer("C_4", s);
        Consumer c5 = new Consumer("C_5", s);
        Consumer c6 = new Consumer("C_6", s);
        Consumer c7 = new Consumer("C_7", s);
        service.submit(p);
        service.submit(p2);

        service.submit(c);
//        service.submit(c2);
//        service.submit(c3);
//        service.submit(c4);
//        service.submit(c5);
//        service.submit(c6);
//        service.submit(c7);
    }
}
