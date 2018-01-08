package ProxyTest.cglibTest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by C.A.O on 2017/12/28.
 */
public class AuthProxy implements MethodInterceptor {
    private String name;

    //传入用户名称
    public AuthProxy(String name) {
        this.name = name;
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        //用户进行判断
        if (!"张三".equals(name)) {
            System.out.println("你没有权限！");
            return null;
        }
        return arg3.invokeSuper(arg0, arg2);
    }
}
