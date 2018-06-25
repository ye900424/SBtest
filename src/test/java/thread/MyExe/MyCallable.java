package thread.MyExe;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Created by C.A.O on 2018/5/29.
 */
@NoArgsConstructor
@Data
public class MyCallable<V> implements Callable<V> {
    private String methodName ;
    private String className ;
    private Object[] args;
    private Class[] clazzss;

    private Class returnClass;


    public MyCallable(String className,String methodName,Object... objects){
        this(className,methodName,null,objects);
    }

    public MyCallable(String className,String methodName,Class returnClass,Object... objects){
        this.className = className;
        this.methodName = methodName;
        this.returnClass = returnClass;
        args = objects;
        clazzss = new Class[objects.length];
        for(int i = 0 ; i < objects.length ; i++){
            clazzss[i] = objects[i].getClass();
        }
    }

    @Override
    public V call() throws Exception {
        Class clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName,clazzss);
        return (V) method.invoke(clazz.newInstance(),args);
    }


    public static void main(String[] args) throws Exception {
        MyCallable<String> myExeTest = new MyCallable<>();
        System.out.println(myExeTest.call());
    }
}
