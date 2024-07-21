package bs2024.string_;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring instance = new lengthOfLongestSubstring();
        System.out.println(instance.lengthOfLongestSubstringm("abcabcbb"));
    }

    public int lengthOfLongestSubstringm(String s) {
        Map<Character,Integer> map = new HashMap();
        int l = 0;
        int max = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char cc = s.charAt(i);
            if(map.containsKey(cc) && map.get(cc) >= l){
                l = map.get(cc) + 1;
            }
            map.put(cc,i);
            max = Math.max(max,i-l+1);
        }

        return max;
    }
}
