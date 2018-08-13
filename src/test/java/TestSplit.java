/**
 * Created by C.A.O on 2018/6/20.
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = "";

        String[] array = str.split("\\|",100);

        System.out.println(array.length);
        for(String str22 : array){
            if(null == str22){
                System.out.println("null");
            }else if("".equals(str22)){
                System.out.println("空字符串");
            }else {
                System.out.println(str22);
            }
        }
    }
}
