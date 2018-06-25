package JVM_test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by C.A.O on 2018/6/21.
 */
public class StackTest {
    private static int i = 0;
    private static int _1KB = 1024;
    private static int _1MB = _1KB*_1KB;




    public static void main(String[] args) {
        try {
            fun();
        } catch (Exception e) {
            System.out.println("轮次：" + i);
            e.getStackTrace();
        }catch(Error e){
            System.out.println("轮次Error：" + i);
            System.out.println(e.getStackTrace());
        }
        finally {
            System.out.println(i);
        }
    }

    public static String fun() {
        byte[] bytes = new byte[2000*_1MB];

        Map map = new HashMap(100);
        Map map2 = new HashMap();
        Map map3 = new HashMap();
        Map map4 = new HashMap(100);
        Map map5 = new HashMap(100);
        i++;
        return fun() + "12345123456oiuytre3456yujhgfdew23456yujhgfdew234tyujkmjnhbgvfd";
    }
}
