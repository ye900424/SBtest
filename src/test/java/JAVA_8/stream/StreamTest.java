package JAVA_8.stream;

import com.google.common.collect.Lists;
import com.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by C.A.O on 2018/6/11.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4);
        Stream<Integer> intStream = intList.stream();


        Person person1 = new Person(1L,"老曹1");
        Person person2 = new Person(2L,"老曹2");
        Person person3 = new Person(1L,"老曹3");
        Person person4 = new Person(2L,"老曹4");
        Person person5 = new Person(5L,"老曹5");

        List<Person> peoples = Lists.newArrayList(person1,person2,person3,person4,person5);

        Map<Long, List<String>> collect = peoples.stream().collect(Collectors.groupingBy(Person::getId, Collectors.mapping(Person::getName, Collectors.toList())));


        collect.entrySet().forEach(System.out::println);



    }
}
