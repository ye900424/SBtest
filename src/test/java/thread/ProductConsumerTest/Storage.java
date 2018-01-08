package thread.ProductConsumerTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Author     :Administrator
 * Time       :15:22
 * Project    :CMSM
 * Package    :thread.ProductConsumerTest
 */
public class Storage {

//    private BlockingQueue<Product> products = new LinkedBlockingQueue<Product>();
    private BlockingQueue<Product> products = new ArrayBlockingQueue<Product>(5);

    /**
     * 生产
     *
     * @param p
     *            产品
     * @throws InterruptedException
     */
    public void push(Product p) throws InterruptedException {
//        products.put(p);
        products.offer(p,2, TimeUnit.MILLISECONDS);
    }

    /**
     * 消费
     *
     * @return 产品
     * @throws InterruptedException
     */
    public Product pop() throws InterruptedException {
//        return products.take();
        return products.poll();
    }
}
