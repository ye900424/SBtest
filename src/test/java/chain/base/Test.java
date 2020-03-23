package chain.base;

/**
 * @author C.A.O
 * @date 2019/8/21
 */
public class Test {
    public static void main(String[] args) {
        //模拟传入的值
        String msg = "";
        //实例化传参类
        Request request=new Request();
        //设置参入的值
        request.setRequestStr(msg);
        //实例化场景操作类
        Client client = new Client();
        //调用add方法，将需要的校验器放进去，多个的话可以在add后面“.addCheck（）”继续添加
        client.addCheck(new NullCheck());
        //调用
        System.out.println(client.validate(request, client));

    }
}
