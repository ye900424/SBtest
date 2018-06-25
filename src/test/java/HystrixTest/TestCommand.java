package HystrixTest;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.functions.Action1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by C.A.O on 2018/5/7.
 */
public class TestCommand extends HystrixCommand<String>{
    protected TestCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected String run() throws Exception {
        return "hello";
    }

    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        TestCommand command = new TestCommand(HystrixCommandGroupKey.Factory.asKey("TestGroup"));

        //1.这个是同步调用
//        command.execute();

        //2.这个是异步调用
//        command.queue().get(500, TimeUnit.MILLISECONDS);

        //3.异步回调
        command.observe().subscribe(new Action1<String>() {
            public void call(String arg0) {

            }
        });
    }
}
