package simpleTest;

/**
 * Created by caoyang on 2017/6/21.
 */
public class StringFormate {
    public static void main(String[] args) {

        String content = "你好，%s的协议供货交易规则已发生变更，%s配置你所在区划%s。点击下面的链接查看具体详情：%s。";
        content = String.format(content,null,"WWW","EEE","RRR");
        System.out.println(content);
    }
}
