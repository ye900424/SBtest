package JsonTest;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by caoyang on 2017/6/10.
 */
public class ListToJson {
    public static void main(String[] args) {
        List list = Lists.newArrayList("6");
        String s = JSONObject.toJSONString(list);
        System.out.println(s);
    }
}
