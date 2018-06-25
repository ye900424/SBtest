package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by caoyang on 2017/7/20.
 */
public class ProxyHandler implements InvocationHandler {

    //真实对象
    Object object;
    Object[] argss;

    public ProxyHandler(Object object,Object[] argss){
        this.object = object;
        this.argss =argss;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        System.out.println("method:"+method);
        Object result = method.invoke(object,args);
        System.out.println("after invoke");
        return result;

    }
}
