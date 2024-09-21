package bs2024.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _676_MagicDictionary {
    public static void main(String[] args) {
        _676_MagicDictionary instance = new _676_MagicDictionary();
        instance.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(instance.search("hello"));
        System.out.println(instance.search("hhllo"));
        System.out.println(instance.search("hell"));
        System.out.println(instance.search("leetcoded"));
    }


    Map<Integer, List<String>> map ;

    public _676_MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for(String str : dictionary){
            int len = str.length();
            if(map.containsKey(len)){
                map.get(len).add(str);
            }else{
                List<String> subList = new ArrayList();
                subList.add(str);
                map.put(len,subList);
            }
        }

    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        List<String> subList = map.get(len);
        if(null == subList){
            return false;
        }

        for(int i = 0 ; i < subList.size() ; i++){
            String str = subList.get(i);
            int maxDiff = 0;
            for(int j = 0 ; j < len ; j++){
                if(maxDiff > 1){
                    break;
                }
                if(str.charAt(j) != searchWord.charAt(j)){
                    maxDiff ++;
                }
            }
            if(maxDiff == 1){
                return true;
            }else{
                return false;
            }
        }

        return false;

    }
}
