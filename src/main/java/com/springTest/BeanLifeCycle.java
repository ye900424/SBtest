package com.springTest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 测试启动类
 */
public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");

//        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:beans.xml");
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:beans.xml");


        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = (Person)factory.getBean("person", Person.class);
//        Person person = null;
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}
