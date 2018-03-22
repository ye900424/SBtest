import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoyang on 2017/7/31.
 */
public class Test_S{
    public static void main(String[] args) {
        String s = "我是大帅比";

        char[] c = new char[4];
        c[0] = '1';
        c[1] = '我';
        System.out.println(c);
        System.out.println(s);

        HashMap map = new HashMap();
        map.put(1,1);
        map.put(2,3);


        map.size();
        map.get(2);



        Map map2 = Collections.synchronizedMap(new HashMap());


    }
}
