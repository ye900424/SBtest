package simpleTest;


/**
 * Created by caoyang on 2017/6/7.
 */
public class IntegerComp {
    public static void main(String[] args) {
        int i = 10000;
        Integer q = new Integer(10000);
        Integer w = 100;
        Integer e = 100;



        System.out.println(w == e);
        System.out.println(i == q);
        System.out.println(i == w);
        System.out.println(q == w);
        System.out.println(q.equals(w));




        String integerCacheHighPropValue =
                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        System.out.println(integerCacheHighPropValue);




        String a = "a";
        String b = "a";
        System.out.println(a==b);



    }
}
