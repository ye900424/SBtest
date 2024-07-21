package bs2024.string_;

import java.util.HashMap;
import java.util.Map;

public class _13_romanToInt {
    public static void main(String[] args) {
        _13_romanToInt instance = new _13_romanToInt();
        System.out.println(instance.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",500);
        map.put("CM",900);

        int sum = 0;
        int idx = 0 ;
        while (idx < s.length()){
            if(idx < s.length() - 1){
                String temp = s.charAt(idx) + s.charAt(idx + 1) + "";
                if(map.containsKey(temp)){
                    sum +=  map.get(temp);
                    idx = idx + 2;
                    continue;
                }
            }

            String temp = s.charAt(idx) + "";
            if(map.containsKey(temp)){
                sum +=  map.get(temp);
                idx = idx + 1;
                continue;
            }
        }
        return sum;
    }
}
