package JAVA_8.lambdaTest;

/**
 * Created by C.A.O on 2018/6/7.
 */
@FunctionalInterface
public interface MyFucInter {
    void fun(Object... obj);

    default void fun2() {
        System.out.println("MyFucInter的default方法");
    }

    static void fun3() {
        System.out.println("MyFucInter的static方法");

    }
}
