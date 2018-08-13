package simpleTest;

import com.google.common.collect.Lists;
import com.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by caoyang on 2017/7/24.
 */
public class Test {
    public static void main(String[] args) {
        List<Person> persions = Lists.newArrayList();
        persions.add(new Person(1l, "1"));
        persions.add(new Person(2l, "2"));
        persions.add(new Person(3l, "3"));
        persions.add(new Person(4l, "4"));
        persions.add(new Person(5l, "5"));

        persions.forEach(person -> {
            person.setId(9l);
        });

        persions.forEach(person -> {
            System.out.println(person.toString());
        });


        System.out.println("我是a大帅1比".length());

        System.out.println(new Date().getTime());


        List<Integer> intlist = new ArrayList<>();

        intlist.add(1);
        intlist.add(10);
        intlist.add(2);
        intlist.add(0,3);




        Integer i = 3;
        Test.fun(persions);
        System.out.println(persions);


        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void fun(List<Person> persions) {
        persions.add(new Person(5l, "6"));
        persions.removeAll(persions);
    }
}
