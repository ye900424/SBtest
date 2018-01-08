package ProxyTest;


import java.lang.reflect.Proxy;

/**
 * Created by caoyang on 2017/7/20.
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();

        Subject subjectProxy = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),new Class[]{Subject.class,Persion.class},new ProxyHandler(subject,null));

        subjectProxy.doSomething(1,"参数2");


        subject = new SubjectImpllllll();

        Persion persion = (Persion) Proxy.newProxyInstance(Persion.class.getClassLoader(),new Class[]{Subject.class,Persion.class},new ProxyHandler(subject,null));

        persion.doThis();

    }
}
