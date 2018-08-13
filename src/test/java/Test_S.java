import com.model.Person;
import org.springframework.util.ClassUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by caoyang on 2017/7/31.
 */
public class Test_S {
    public static void main(String[] args) {



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



        fun2();

        System.out.println("&&&&");
        System.out.println((null instanceof Integer) + "&&&&");



    }

    public static String fun2(){
        System.getProperties();

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassUtils.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        return "";
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
