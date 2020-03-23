package JAVA_8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/11/12
 */
public class OptionalTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1234");
        list.add("2345");
        list.add("2345");
        list.add("4567");
        List<String> list1 = null;


        Optional.ofNullable(list).orElse(new ArrayList<>());
        Optional.ofNullable(list1).ifPresent(strList -> strList.add("###"));


        System.out.println(list);
        System.out.println(list1);


    }
}
