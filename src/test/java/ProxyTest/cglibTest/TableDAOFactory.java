package ProxyTest.cglibTest;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * Created by C.A.O on 2017/12/28.
 */
public class TableDAOFactory {
    private static TableDAO tDao = new TableDAO();
    public static TableDAO getInstance(){
        return tDao;
    }


    public static TableDAO getAuthInstance(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(TableDAO.class);
        en.setCallback(authProxy);
        //生成代理实例
        return (TableDAO)en.create();
    }

    public static TableDAO getAuthInstanceByFilter(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        en.setSuperclass(TableDAO.class);
        en.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
        en.setCallbackFilter(new AuthProxyFilter());
        return (TableDAO)en.create();
    }
}
