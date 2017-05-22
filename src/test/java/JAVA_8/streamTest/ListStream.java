package JAVA_8.streamTest;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by caoyang on 2017/5/2.
 */
public class ListStream {
    public static void main(String[] args) {
        ListStream.fun();
    }

    public static void fun(){
        List<Integer> list = Lists.newArrayList(1,null,2,null,4,75,23,0,1,1,1,1);
        System.out.println(list.stream().filter( x ->  x != null).count());
        System.out.println(list.stream().findFirst());

//        Lists.transform(list,);

//        list.stream().filter(num -> num != null).count();


//guava
        List<String> strList = Lists.newArrayList("awed","qq","qweqweqwe","","qweqw");
        List<Integer> intList = Lists.transform(strList, new Function<String, Integer>() {
            @Override
            public Integer apply(String from) {
                return from.length();
            }
        });
        intList.forEach(x -> {
            System.out.println(x);
        });


        Set<String> str = strList.stream().map(x -> {
            System.out.println("ok");
            return x+"_";
        }).collect(Collectors.toSet());
        str.forEach(x -> {
            System.out.println(x);
        });

        strList.stream().skip(9);
    }
}
