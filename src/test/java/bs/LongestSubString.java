package bs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author C.A.O
 * @date 2020/3/11
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        for(int i = 0 ; i < s.length() ; i ++){
            Map map = new HashMap();
            for(int j = i ; j< s.length(); j++){
                if(!map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),0);
                }else{
                    res = Math.max(res,map.size());
                    break;
                }
            }
            res = Math.max(res,map.size());
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubString instance = new LongestSubString();
        System.out.println(instance.lengthOfLongestSubstring("pwwkew"));

    }
}
