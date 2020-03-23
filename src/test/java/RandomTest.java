import java.util.Random;

/**
 * @author: C.A.O
 * @Description:
 * @Date: 2018/12/12
 */
public class RandomTest {
    public static void main(String[] args) {
        Integer num = 0;
        for(int i = 0; i < 100; i++){
            num = new Random().nextInt(100);
            int j = num >> 2 | 1;
            System.out.println(num + " | " + j);

        }
    }
}
