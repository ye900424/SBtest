package JAVA_8.lambdaTest;

import com.model.Person;

import java.util.function.Function;

/**
 * Created by C.A.O on 2018/6/7.
 */
public class Test {
    MyFucInter myFucInter = (s) -> System.out.println("lambda表达式实现函数式接口");

    public static void main(String[] args) {
        Test test = new Test();
        test.myFucInter.fun("123");
        test.myFucInter.fun2();
        MyFucInter.fun3();

//        String s = "";
        MyFucInter myFucInter1 = (Object[] s) -> System.out.println("lambda表达式实现函数式接口");

        Function<String,Integer> function= (s) -> Integer.parseInt(s);
        System.out.println(function.apply("2345"));


        System.out.println("cpu核数" + Runtime.getRuntime().availableProcessors());

        TestInterface testInterface = rrrr -> {
            Person person = new Person();
            return person;
        };

    }
}
