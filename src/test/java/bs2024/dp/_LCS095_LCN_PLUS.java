package bs2024.dp;

public class _LCS095_LCN_PLUS {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        _LCS095_LCN_PLUS instance = new _LCS095_LCN_PLUS();
        System.out.println(instance.longestCommonSubsequence(text1,text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if(null == text1 || text1.isEmpty() || null == text2 || text2.isEmpty()){
            return 0;
        }

        int[][] states = new int[text1.length()+1][text2.length()+1];

        for(int i = 1; i <= text1.length();i++){
            for(int j = 1; j <= text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    states[i][j] = states[i-1][j-1] + 1;
                }else{
                    states[i][j] = Math.max(states[i][j-1],states[i-1][j]);
                }
            }
        }

        return states[text1.length()][text2.length()];
    }
}
