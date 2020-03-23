import com.model.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by C.A.O on 2018/7/10.
 */
public class BTTest {


    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1L);
        person.setName("11111");
        BTTest btTest = new BTTest();
//        btTest.modifyBean(person);
        System.out.println(person.getId());


        HashMap<String,Person> map = new HashMap<>();
        map.put("1",person);

        HashMap<String,Person> map222 = new HashMap<>();
        map222.put("1",person);

        System.out.println("hashCode:" + map.hashCode());
        HashMap<String,Person> cloneMap = (HashMap<String,Person>)map.clone();
        System.out.println("hashCode:" + cloneMap.hashCode());
        System.out.println("hashCode:" + map222.hashCode());
        System.out.println(map);
        cloneMap.get("1").setId(2L);
        cloneMap.put("2",null);
        System.out.println(map == cloneMap);


//        btTest.modifyMap(map);
        System.out.println(map);



        Integer integer = 3;
        Integer r = new Random().nextInt(integer >> 2 | 1);

        System.out.println(new Random().nextInt(10));
        System.out.println(86399 << 10 | 1);
        System.out.println(r);

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(1024));

        // N台机器
        int N = 10;
        // M集群秒并发上线
        int M = 1024;


        Long secondsOffset = 86399L;
        int WORKER_ID_BITS = Integer.toBinaryString(10).length();
        int SEQUENCE_BITS = Integer.toBinaryString(1024).length();

        long result = (secondsOffset << (WORKER_ID_BITS + SEQUENCE_BITS))
                | (10 << SEQUENCE_BITS)
                | 1024;
        System.out.println("当前配置下的最大id: " + result);
    }

    public void modifyBean(Person person){
        Person person1  = new Person();
        person = person1;
        person.setId(2L);
    }

    public void modifyMap(Map<String,String> map){
        map.remove("1");
    }
}
