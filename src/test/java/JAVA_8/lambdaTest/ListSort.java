package JAVA_8.lambdaTest;

import com.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by caoyang on 2017/8/9.
 */
public class ListSort {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(5l,"5"));
        list.add(new Person(9l,"9"));
        list.add(new Person(1l,"1"));
        list.add(new Person(2l,"2"));
        list.add(new Person(6l,"6"));
        list.add(new Person(3l,"3"));


        list.forEach(x -> System.out.println(x.getId() + "|"));
        System.out.println();
        list.sort((obj2, obj1) -> obj1.getName().compareTo(obj2.getName()));
        list.forEach(x -> System.out.println(x.getId() + "|"));


        list.stream().map((Person x) -> x.getName()).collect(Collectors.toList());
    }
}
