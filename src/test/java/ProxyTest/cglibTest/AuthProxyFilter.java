package ProxyTest.cglibTest;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by C.A.O on 2017/12/28.
 */
public class AuthProxyFilter implements CallbackFilter {
    public int accept(Method arg0) {
        if(!"query".equalsIgnoreCase(arg0.getName()))
            return 0;
        return 1;
    }
}
