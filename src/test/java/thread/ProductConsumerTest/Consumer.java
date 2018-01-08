package thread.ProductConsumerTest;

/**
 * Author     :Administrator
 * Time       :15:21
 * Project    :CMSM
 * Package    :thread.ProductConsumerTest
 */
public class Consumer implements Runnable{
    private String name;
    private Storage s = null;

    public Consumer(String name, Storage s) {
        this.name = name;
        this.s = s;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(name + "Want to use.");
                Product product = s.pop();
                System.out.println(name + "Is used(" + product.toString() + ").");
                System.out.println("===============");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
