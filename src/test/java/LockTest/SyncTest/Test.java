package LockTest.SyncTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by C.A.O on 2017/12/28.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class[] clazzs = new Class[2];
        clazzs[0] = String.class;
        clazzs[1] = Integer.class;
        Method method = LockFun.class.getDeclaredMethod("fun",clazzs);
        method.setAccessible(true);
        method.invoke(LockFun.class.newInstance(),"1",2);




        LockFun.class.getDeclaredFields();


        System.out.println(LockFun.class.getDeclaredField("ttt").getName());

    }
}
