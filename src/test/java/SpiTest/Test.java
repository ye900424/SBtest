package SpiTest;

import com.model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ServiceLoader;

/**
 * Created by C.A.O on 2018/7/30.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        ServiceLoader<Person> loaders = ServiceLoader.load(Person.class);


        try {
            Enumeration<URL> configs = ClassLoader.getSystemResources("https://www.yiibai.com/java/lang/classloader_getsystemresource.html");
            System.out.println(configs.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
