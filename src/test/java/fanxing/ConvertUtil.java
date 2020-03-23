package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author C.A.O
 * @date 2019/7/4
 */
public class ConvertUtil {

    public <T> List<T> convert(List<Object> list, Class<T> tClass) {
        List<T> resultList = new ArrayList<>();
        return resultList;
    }

    public <T> T convert(Object pbj, Class<T> tClass) {
        return (T)tClass;
    }

}
