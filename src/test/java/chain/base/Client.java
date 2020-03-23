package chain.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author C.A.O
 * @date 2019/8/21
 */
public class Client implements Check {
    /**
     * 用List集合来存储效验规则
     * */
    List<Check> checks = new ArrayList<>();
    /**
     * 用于标记规则的引用顺序
     * */
    int index = 0;
    /**
     * 往规则链条中添加规则
     * */
    public Client addCheck(Check filter) {
        checks.add(filter);
        return this;
    }

    @Override
    public HashMap<String, Object> validate(Request request, Client client) {
        HashMap<String, Object> map = new HashMap<>(16);
        //index初始化为0,checks.size()为校验器的数量，不会执行return操作
        if (index == checks.size()) {
            map.put("res", "校验结束");
            return map;
        }

        Check check = checks.get(index);
        //每添加一个过滤规则，index自增1
        index++;
        //根据索引值获取对应的规律规则对字符串进行处理
        map = check.validate(request, client);
        return map;
    }
}
