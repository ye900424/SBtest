package thread;

import lombok.extern.slf4j.Slf4j;
import thread.MyExe.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * Created by yiming on 2018-04-11 16:35.
 * Description:
 *
 * @author <a href="mailto:nishibin@cai-inc.com"></a>
 */
@Slf4j
public class FixedThreadUtils<T, R> {
    private static FixedThreadUtils ME = null;
    private ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                    Runtime.getRuntime().availableProcessors(),
                    1L, TimeUnit.MINUTES,
                    new LinkedBlockingQueue<>(),
                    new NamedThreadFactory("FixedThreadFactory"));

    private FixedThreadUtils() {

    }

    public static FixedThreadUtils getInstance() {
        if (ME == null) {
            ME = new FixedThreadUtils();
        }
        return ME;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void destroy() {
        threadPoolExecutor.shutdown();
    }

    @Deprecated
    public R singleRun(T t, Consumer<T> consumer) {
        Future<?> future = threadPoolExecutor.submit(() -> consumer.accept(t));
        try {
            Object x = future.get();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error(e.getMessage());
        }
        threadPoolExecutor.shutdown();
        return null;
    }

    @Deprecated
    public List<R> parallelRun(List<T> datas, Consumer<T> consumer) {
        List<Future<R>> futureList = new ArrayList<>();
        if (datas != null && !datas.isEmpty()) {
            datas.forEach(data -> futureList.add(threadPoolExecutor.submit(() -> consumer.accept(data), null)));
        }
        List<R> res = new ArrayList<>();
        futureList.forEach(f -> {
            try {
                res.add(f.get());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                log.error(e.getMessage());
            }
        });
        return res;
    }

}

