package ProxyTest.cglibTest;

/**
 * Created by C.A.O on 2017/12/28.
 */
public class Client {
    public static void main(String[] args) {
        TableDAO tableDao = TableDAOFactory.getInstance();
        doMethod(tableDao);

        haveAuth();
        haveNoAuth();

        haveAuthByFilter();
    }
    public static void doMethod(TableDAO dao){
        dao.create();
        dao.query();
        dao.update();
        dao.delete();
    }

    public static void haveAuth(){
        TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("张三"));
        doMethod(tDao);
    }
    public static void haveNoAuth(){
        TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("李四"));
        doMethod(tDao);
    }

    public static void haveAuthByFilter(){
        TableDAO tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("张三"));
        doMethod(tDao);

        tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("李四"));
        doMethod(tDao);
    }
}
