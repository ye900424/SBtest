import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoyang on 2017/7/31.
 */
public class Test_S {
    public static void main(String[] args) {

        System.out.println(2 | 1);
        System.out.println(3 | 1);
        System.out.println(2 & 1);
        System.out.println(3 & 1);
        System.out.println(('a' ^ 'a') == 0);
        System.out.println('a' - '0');


        String str1 = "hello";
        String str2 = "hhllo";
        int count = 0;
        for(int i = 0 ; i < 5 ;i++){
            if((str1.charAt(i) ^ str2.charAt(i)) != 0){
                count++;
            }
        }
        System.out.println(count);


        System.out.println(('b'-'a') == 1);

    }
}
