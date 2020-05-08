package JAVA_8.completeFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author C.A.O
 * @date 2020/4/16
 */
public class Test {
    public static void main(String[] args) {
        CompletableFuture<Object> origin = new CompletableFuture<>();
        try {
            System.out.println("start");
            origin.get(2000, TimeUnit.MILLISECONDS);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
