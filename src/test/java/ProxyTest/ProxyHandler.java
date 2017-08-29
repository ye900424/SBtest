package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by caoyang on 2017/7/20.
 */
public class ProxyHandler implements InvocationHandler {

    Object object;
    Object[] argss;

    public ProxyHandler(Object object,Object[] argss){
        this.object = object;
        this.argss =argss;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object,args);
    }
}
