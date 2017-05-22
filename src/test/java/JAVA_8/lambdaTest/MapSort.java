package JAVA_8.lambdaTest;

import java.util.*;

/**
 * Created by caoyang on 2017/5/2.
 */
public class MapSort {
    public static void main(String[] args) {
        MapSort.mapSort();
    }

    public static void mapSort() {
        Map map = new HashMap();
        map.put(7, "d");
        map.put(1, "a");
        map.put(4, "b");
        map.put(8, "e");
        map.put(5, "c");

        Map sortedMap = new TreeMap<Integer, String>((x, y) -> y-x);

        map.forEach((k, v) -> sortedMap.put(k, v));

        sortedMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public void listSort() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(12);
        list.add(30);
        list.add(1);
        list.add(10);
        list.add(11);
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(18);
        list.add(0);

        list.forEach(x -> System.out.println(x + "|"));
        System.out.println();
        list.sort((obj1, obj2) -> obj1 - obj2);
        list.add(6);
        list.forEach(x -> System.out.println(x + "|"));

    }
}


