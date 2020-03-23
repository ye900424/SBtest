package chain.base;

import java.util.HashMap;

/**
 * @author C.A.O
 * @date 2019/8/21
 */
public interface Check {
    HashMap<String, Object> validate(Request request, Client client);

}
