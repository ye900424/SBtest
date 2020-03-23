package com;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.File;

/**
 * Author     :Administrator
 * Time       :15:57
 * Project    :TestEhcache
 * Package    :com.caoyang
 */
public class TestEc {
//    private Cache cache;
    public static void main(String[] args) {
//        TestEc testEc = new TestEc();
//        CacheManager.getInstance().getCacheManagerEventListenerRegistry();
//        Element element = new Element("caoyang","shuai");
//        testEc.cache.put(element);
//        testEc.cache.get("caoyang");

        File file = new File("/Users/caoyang/IdeaProjects/SBTest/target/test-classes/ehcache.xml");


        //创建一个缓存管理器
        CacheManager cacheManager = CacheManager.create("/Users/caoyang/IdeaProjects/SBTest/target/test-classes/ehcache.xml");
        //建立一个缓存实例
        Cache memoryOnlyCache = new Cache("testCache", 5000, false, false, 5, 2);
        //在内存管理器中添加缓存实例
        cacheManager.addCache(memoryOnlyCache);
        //在缓存管理器中获取一个缓存实例
        Cache cache = cacheManager.getCache("testCache");
        //使用获取到的缓存实例
        Element element = new Element("key1", "value1");
        cache.put(element);//添加缓存值
        cache.put(new Element("key2", "value2"));//添加缓存值

        int elementsInMemory = cache.getSize();//获取缓存个数
        System.out.println("缓存个数======="+elementsInMemory);

//        Object obj = element.getObjectValue();//获取对象值
//        cache.remove("key1");//删除缓存

        Cache cache2 = cacheManager.getCache("testCache");//获取缓存实例
        Element element2 = cache2.get("key1");
        System.out.println("value====="+element2.getValue());//获取缓存值

        Cache hcache = cacheManager.getCache("helloworld1");
        Element element1 = new Element("caoyang","shuai");
        hcache.put(element1);
        hcache.get("caoyang");
        System.out.println(cache2.get("helloworld1").getValue());
    }
}
