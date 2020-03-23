package fanxing;

/**
 * @author C.A.O
 * @date 2019/7/4
 */
public class Child extends Parent{


    @Override
    public <T> T convert(Object ojb, Class<T> tClass) {
        return (T) tClass;
    }
}
