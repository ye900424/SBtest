package thread.MyExe;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

/**
 * Created by C.A.O on 2018/6/9.
 * 一个任务组一个实例
 */
public class AsyncExecutor<U> {

    private long TIME_OUT_10S = 5l;

    private HashMap<String, CompletableFuture> futureMap = new HashMap<>();
    private List<CompletableFuture> futureList = new ArrayList<>();

    /**
     *
     * @param supplier 目标函数
     * @return
     */
    public CompletableFuture add(Supplier<U> supplier) {
        return this.add("",supplier);
    }

    /**
     * 执行任务，结果future放入实例对象的集合
     * @param supplier
     * @return
     */
    public CompletableFuture add(String key,Supplier<U> supplier) {
        CompletableFuture future = CompletableFuture.supplyAsync(supplier);
        futureList.add(future);
        if(!StringUtils.isEmpty(key)){
            futureMap.put(key, future);
        }
        future.exceptionally(e -> {
//            System.out.println(e.getMessage());
            return "hello world";
        });
        return future;
    }

    /**
     * 所有结果合并future，判断是否完成
     * 10s等待时间，超时报异常
     */
    public CompletableFuture isFinished() {
        CompletableFuture completableFuture = null;

        try {
            System.out.println("####isFinished-start###");
            CompletableFuture<?>[] completableFutures = new CompletableFuture[futureList.size()];

            completableFuture = CompletableFuture.allOf(futureList.toArray(completableFutures));
            completableFuture.get(TIME_OUT_10S,TimeUnit.SECONDS);
            System.out.println("####isFinished-end###");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return completableFuture;
    }


    /**
     * 获取返回值
     *
     * @param key：自定义
     * @return
     */
    public Object getResult(String key) {
        if (!futureMap.containsKey(key)) {
            System.out.println("不存在此key："+key);
            throw new RuntimeException("XXX");
        }
        Object result = null;
        try {
            result = futureMap.get(key).get(TIME_OUT_10S, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 返回真实结果map
     * @return
     */
    public Map<String, Object> getResultMap() {
        Map<String, Object> resultMap = new HashMap<>();

        for(HashMap.Entry entry : futureMap.entrySet()){
            resultMap.put((String)entry.getKey(),entry.getValue());
        }

//        futureList.parallelStream().map(future -> {
//            Object obj = null;
//            try {
//                obj = future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            return obj;
//        }).collect(Collectors.toList());

        return resultMap;
    }

}
