package bs2024.string_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_myAtoi {

    public static void main(String[] args) {
        _8_myAtoi instance = new _8_myAtoi();
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(instance.myAtoi("-2147483649"));
    }

    public int myAtoi(String s) {
        // 去除前置空格
        while(true){
            if(s.startsWith(" ")){
                s = s.substring(1,s.length());
            }else{
                break;
            }
        }

        // 判断正负
        int tag = 1;
        if(s.startsWith("-")){
            tag = -1;
            s = s.substring(1,s.length());
        }else if(s.startsWith("+")){
            s = s.substring(1,s.length());
        }

        // 去除前置0
        while(true){
            if(s.startsWith("0")){
                s = s.substring(1,s.length());
            }else{
                break;
            }
        }


        // 转换+舍入
        int sum = 0;
        int idx = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);

            if(c-'0' < 0 || c-'0' > 9){
                break;
            }

            if(sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && c-'0' > Integer.MAX_VALUE % 10)){
                sum = Integer.MAX_VALUE;
                break;
            }

            if(sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && c-'0' > -1*(Integer.MIN_VALUE % 10))){
                sum = Integer.MIN_VALUE * tag;
                break;
            }


            sum *= 10;
            sum += (c-'0') * tag;
            idx++;
        }


        return sum ;
    }


}
