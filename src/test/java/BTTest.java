import com.model.Person;

import java.util.HashMap;
import java.util.Map;

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
