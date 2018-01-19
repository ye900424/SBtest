package thread.ReenTrantLockTest;

/**
 * Author     :Administrator
 * Time       :17:12
 * Project    :CMSM
 * Package    :thread.ReenTrantLockTest
 */


import com.fasterxml.jackson.databind.util.LRUMap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {

	private static final LRUMap detailMutexMap = new LRUMap(100000,100000);

	private static final LRUMap uvMutexMap = new LRUMap(10000,100000);

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