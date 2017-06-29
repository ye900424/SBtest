package simpleTest;

import model.Person;

/**
 * Created by caoyang on 2017/6/7.
 */
public class MethodTest {

    public static void main(String[] args) {
        MethodTest methodTest = new MethodTest();
        methodTest.fun();

        Person person = new Person();
        System.out.println("########");
        System.out.println(person.getId());
        System.out.println(person.getId() == null);
        System.out.println(person.getId().equals(0l));
    }

    public void fun(){
        Person person = new Person(1l,"caoyang");
        if(fun1(person)){
            System.out.println(123213);
        }

        System.out.println(person.toString());

    }

    public Boolean fun1(Person person){
        person.setSex(1);
        person.setAge(28);

        return true;
    }
}
