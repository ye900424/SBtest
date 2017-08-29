package simpleTest;

import com.google.common.collect.Lists;
import model.Person;

import java.util.Date;
import java.util.List;

/**
 * Created by caoyang on 2017/7/24.
 */
public class Test {
    public static void main(String[] args) {
        List<Person> persions = Lists.newArrayList();
        persions.add(new Person(1l,"1"));
        persions.add(new Person(2l,"2"));
        persions.add(new Person(3l,"3"));
        persions.add(new Person(4l,"4"));
        persions.add(new Person(5l,"5"));

        persions.forEach(person -> {
            person.setId(9l);
        });

        persions.forEach(person -> {
            System.out.println(person.toString());
        });




        System.out.println("我是a大帅1比".length());

        System.out.println(new Date().getTime());
    }
}
