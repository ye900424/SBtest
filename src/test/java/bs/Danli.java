package bs;

/**
 * @author C.A.O
 * @date 2020/1/7
 */
public class Danli {
    private Danli(){}

    private static volatile Danli danli;

    public static Danli getInstance(){

        if(null == danli){
            synchronized (Danli.class){
                if(danli == null){
                    danli = new Danli();
                }
            }
        }
        return danli;
    }
}
