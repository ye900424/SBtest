package bs2024.array;

import java.util.HashMap;
import java.util.Map;

public class _76_MinWindow {
    public static void main(String[] args) {
        _76_MinWindow instance = new _76_MinWindow();
        System.out.println(instance.minWindow("a","a"));
    }


    Map<Character,Integer> tMap = new HashMap<>();
    Map<Character,Integer> sMap = new HashMap<>();

    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        // 表示窗口内的字符串不包含t的字符数量
        int count = 0;
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                count ++;
            }
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        int l=0,startIdx=-1,len = s.length();
        for(int r = 0 ; r < s.length(); r++){
            char temp = s.charAt(r);
            if(!map.containsKey(temp)){
                continue;
            }

            map.put(temp,map.get(temp) - 1);
            if(map.getOrDefault(temp,0) == 0){
                count --;
            }


            while(count == 0){
                if(r-l+1 <= len){
                    len = r-l+1;
                    startIdx = l;
                }
                char lc = s.charAt(l);
                if(map.containsKey(lc)){
                    map.put(lc,map.get(lc) + 1);
                    if(map.get(lc) > 0){
                        count ++;
                    }
                }
                l++;
            }
        }

        return startIdx == -1 ? "" : s.substring(startIdx,startIdx + len);
    }

    public boolean checkContainsT(){
        for(Map.Entry<Character,Integer> entry : tMap.entrySet()){
            char c = entry.getKey();
            int cnt = entry.getValue();
            if(sMap.getOrDefault(c,0) < cnt){
                return false;
            }
        }

        return true;
    }
}
