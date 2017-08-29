package ExceptionTest;

/**
 * Created by caoyang on 2017/8/17.
 */
public class Test {
    public static void main(String[] args) {
        StateException stateException = new StateException();
        System.out.println(stateException instanceof DesionedException);
        System.out.println(stateException instanceof ServiceException);
        System.out.println(stateException instanceof StateException);
    }
}
