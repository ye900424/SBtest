package simpleTest;

/**
 * Created by caoyang on 2017/6/11.
 */
public class ReplaceTest {
    public static void main(String[] args) {
        String s = "330000";
        System.out.println(s.replace("00",""));
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }
}
