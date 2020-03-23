import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author C.A.O
 * @date 2019/5/17
 */
public class RandomOnDuty {
    private static String marksWords = "请输入0517SpringBoot升级值班候选人";
    private static String resultWords = "经过公平计算今晚值班人员为：";
    private static Integer count = 3;

    public static void main(String[] args) {

        List<String> candidates = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        for (int i = 1; i <= count; i++) {
            System.out.println(marksWords + i);

            if (!in.hasNext()) {
                break;
            }
            candidates.add(in.next());
        }

        System.out.println(resultWords + candidates.get((int) (Math.random() * 100)%3));

    }
}
