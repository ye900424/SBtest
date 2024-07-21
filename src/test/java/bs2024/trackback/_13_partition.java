package bs2024.trackback;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _13_partition {
    public static void main(String[] args) {
        _13_partition instance = new _13_partition();
        System.out.println(instance.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> retList = new ArrayList();
        char[] chars = s.toCharArray();
        backtrack(chars,0,new ArrayList<>(),retList);
        return retList;
    }

    public void backtrack(char[] chars,int start,List<String> path,List<List<String>> retList){
        if(start >= chars.length){
            retList.add(new ArrayList(path));
            return;
        }

        for(int i = start; i< chars.length ; i++){
            if(!check(chars,start,i)){
                continue;
            }
            path.add(String.valueOf(chars,start,i-start+1));
            backtrack(chars,i+1,path,retList);
            path.remove(path.size() - 1);
        }

    }

    // 判断是否是回文串
    public boolean check(char[] chars,int l ,int r){
        if(l == r){
            return true;
        }

        while(l < r){
            if(chars[l] != chars[r]){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
