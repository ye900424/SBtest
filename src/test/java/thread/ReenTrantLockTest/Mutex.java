package thread.ReenTrantLockTest;

/**
 * Author     :Administrator
 * Time       :17:12
 * Project    :CMSM
 * Package    :thread.ReenTrantLockTest
 */
import org.apache.commons.collections.map.LRUMap;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {

	private static final Map<String, Object> detailMutexMap = new LRUMap(100000);

	private static final Map<String, Object> uvMutexMap = new LRUMap(10000);

	private static final Lock uvLock = new ReentrantLock();

	private static final Lock detailLock = new ReentrantLock();

	public static Lock getDetailMutex(String key) {
		Object value = detailMutexMap.get(key);
		if (value == null) {
			detailLock.lock();
			try {
				value = detailMutexMap.get(key);
				if (value == null) {
					value = new ReentrantLock();
					detailMutexMap.put(key, value);
				}
			} finally {
				detailLock.unlock();
			}

		}
		return (Lock) value;
	}

//	public static Lock getUvMutex(String key) {
//		Object value = uvMutexMap.get(key);
//		if (value == null) {
//			uvLock.lock();
//			try {
//				value = uvMutexMap.get(key);
//				if (value == null) {
//					value = new ReentrantLock();
//					uvMutexMap.put(key, value);
//				}
//			} finally {
//				uvLock.unlock();
//			}
//
//		}
//		return (Lock) value;
//	}

}