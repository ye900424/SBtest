import model.Person;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by caoyang on 2017/7/31.
 */
public class Test_S {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("0");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1d");
        list.add("2d");
        list.add("3d");
        list.add("4d");
        list.add("5d");
        list.parallelStream().forEach(s -> {
            if("2".equals(s)){
                throw new RuntimeException("12345678");
            }
            System.out.println(s);
        });

        Long l = 2345l;
        Integer inhh = l.intValue();


        String s = "我是大帅比";

        char[] c = new char[4];
        c[0] = '1';
        c[1] = '我';
        System.out.println(c);
        System.out.println(s);

        HashMap map = new HashMap();
        map.put(1, 1);
        map.put(2, 3);


        map.size();
        map.get(2);


        Map map2 = Collections.synchronizedMap(new HashMap());

        AtomicBoolean active = new AtomicBoolean();

        System.out.println(active.get());



    }


    public String  fun(String s1,String s2) {
        System.out.println(s1);
        System.out.println(s2);

        return s1+s2;

    }


    public Person  happy(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getId());

        person.setSex(1234567);
        person.setId(88888l);

        return person;

    }
}
