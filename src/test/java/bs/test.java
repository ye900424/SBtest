package bs;

/**
 * @author C.A.O
 * @date 2020/1/31
 */
public class test {

    public static void main(String[] args) {
        test test = new test();
        test.binaryToDecimal(10);
        test.fun(11,2);
    }

    public static void fun(int n, int b){
        int a = n;
        int k = 0;
        String sum = "";
        int r ;

        while(a != 0){
            // 余数
            r = a%b;
            // 商
            a = a/b;

            sum += String.valueOf(r);
        }
        System.out.println(sum);
    }

    public void binaryToDecimal(int n) {
        // TODO Auto-generated method stub

        int a = 11;//定义一个变量并赋给他一个十进制的值
        int remainder;//定义一个变量用于存储余数
        int sum = 0;//定义一个变量用于存放和
        int k = 1;//定义一个变量控制位数

        while (a != 0) {

            remainder = a % 2;//对目标数字求余
            a /= 2;//对目标数字求商
            sum = sum + remainder * k;//求和
            k *= 10;//改变位数

        }
        System.out.println("10进制的11转换为2进制结果为：" + sum);
    }

}
