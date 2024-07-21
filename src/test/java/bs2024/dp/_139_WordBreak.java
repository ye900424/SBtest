package bs2024.dp;

import com.google.common.collect.Lists;

import java.util.List;

public class _139_WordBreak {
    public static void main(String[] args) {
        _139_WordBreak instance = new _139_WordBreak();
        System.out.println(instance.wordBreak("leetcode", Lists.newArrayList("leet","code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() ; i++){
            for(String word : wordDict){
                if(i < word.length()){
                    continue;
                }
                String temp = s.substring(i-word.length(),i);
                if(dp[i - word.length()] && temp.equals(word)){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
