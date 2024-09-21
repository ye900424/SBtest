package bs2024.dp;

import com.google.common.collect.Lists;

import java.util.List;

public class _139_WordBreak {
    public static void main(String[] args) {
        _139_WordBreak instance = new _139_WordBreak();
        System.out.println(instance.wordBreak("dogs", Lists.newArrayList("dog","s","gs")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (word.length() > i) {
                    continue;
                }
                if (s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = dp[i - word.length()];
                }
            }
        }

        return dp[s.length()];
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//        for(int i = 1; i < s.length() ; i++){
//            for(String word : wordDict){
//                if(i < word.length()){
//                    continue;
//                }
//                String temp = s.substring(i-word.length(),i);
//                if(dp[i - word.length()] && temp.equals(word)){
//                    dp[i] = true;
//                }
//            }
//        }
//
//        return dp[s.length()];
//    }
}
