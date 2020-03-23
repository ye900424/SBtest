package chain.base;

import java.util.HashMap;

/**
 * @author C.A.O
 * @date 2019/8/21
 */
public class NullCheck implements Check{
    @Override
    public HashMap<String, Object> validate(Request request, Client client) {
        HashMap<String, Object> map = new HashMap<>(16);
        if (request.getRequestStr() != null && !"".equals(request.getRequestStr())) {
            map = client.validate(request, client);
        }else {
            map.put("error", "字段不能为空");
            return map;
        }
        return map;
    }

}
