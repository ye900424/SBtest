package ClazzTest;

/**
 * Created by C.A.O on 2017/12/21.
 */
public class ClazzTest extends Object{
    public static void main(String[] args) {
        ClazzTest.class.getDeclaredMethods();
        ClazzTest.class.getMethods();
    }

    public void fun1(){}
     void fun2(){}
    private void fun3(){}
    protected void fun4(){}
}
