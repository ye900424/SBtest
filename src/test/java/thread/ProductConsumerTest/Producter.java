package thread.ProductConsumerTest;

/**
 * Author     :Administrator
 * Time       :15:21
 * Project    :CMSM
 * Package    :thread.ProductConsumerTest
 */
public class Producter implements Runnable{
    private String name;
    private Storage s;
    private long SLEEP;

    public Producter(String name,Storage s,long time){
        this.name = name;
        this.s = s;
        this.SLEEP = time;
    }

    @Override
    public void run() {
        try {
            for(int i = 0;i<1000;i++){
//            while (true) {
                Product product = new Product(i); // 产生0~9999随机整数
                System.out.println(name + "Want to make(" + product.toString() + ").");
                s.push(product);
                System.out.println(name + "Have Maked(" + product.toString() + ").");
                System.out.println("===============");
                Thread.sleep(SLEEP);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
