package JAVA_8;

/**
 * Created by caoyang on 2017/5/2.
 */
public interface InterfaceTest {

    public void geiIdByName();

    default public void geiIdByName2(){
        System.out.println(123123);
    }

    default public void geiIdByName3(){
        System.out.println(123123);
    }
}
