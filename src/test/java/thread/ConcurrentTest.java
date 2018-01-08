package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Author     :Administrator
 * Time       :10:23
 * Project    :CMSM
 * Package    :thread
 */
public class ConcurrentTest {
    public static void main(String[] args) {
        Map map = new HashMap();

        ConcurrentHashMap conMap = new ConcurrentHashMap();
        conMap.put(1,1);
        conMap.get(1);


        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.add(11);

        concurrentLinkedQueue.contains(1);
    }
}
