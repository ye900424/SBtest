import com.alibaba.druid.sql.visitor.functions.Char;

import java.io.Serializable;

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
    }
}
