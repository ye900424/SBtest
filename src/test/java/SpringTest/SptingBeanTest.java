package SpringTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by C.A.O on 2018/6/21.
 */
public class SptingBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        context.getBean("orOrderService");
    }
}
