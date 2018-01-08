package ProxyTest;

/**
 * Created by caoyang on 2017/7/20.
 */
public class SubjectImpllllll implements Subject,Persion{


    public void doSomething(int i,String s) {
        System.out.println("i:"+i+" s:"+s);
        System.out.println("test_ok!!!!!!!!");
    }

    @Override
    public void doSomething() {
        System.out.println("do_something");
    }

    @Override
    public void doWhat() {
        System.out.println("do_what");
    }

    @Override
    public void doGgggg() {
        System.out.println("do_gggg");
    }


    @Override
    public void doThis() {
        System.out.println("do_this");
    }
}
