package ClassLoaderTest;

/**
 * Created by C.A.O on 2018/7/25.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        System.out.println("1:"+test.getClass().getClassLoader().toString());
        System.out.println("2:"+test.getClass().getClassLoader().getParent().toString());
        System.out.println("application-classloader："+System.getProperty("sun.boot.class.path"));
        System.out.println("extention-classloader："+System.getProperty("java.ext.dirs"));

        try {
            test.getClass().getClassLoader().loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
