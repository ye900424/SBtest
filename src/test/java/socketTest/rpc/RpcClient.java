package socketTest.rpc;

/**
 * Created by cy111966 on 2016/7/19.
 */
public class RpcClient {

    public static void main(String[] args) {
        String ip ="127.0.0.1";
        int port =9001;
        IHello iHello = ProxyFactory.create(IHello.class, ip, port);
        System.out.println(iHello.sayHello("cy1"));
    }
}
