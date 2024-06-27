package bs2024.dp;

public class _LCS095_LCN_PLUS {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int[][] record = new int[text1.length()+1][text2.length()+1];
        _LCS095_LCN_PLUS instance = new _LCS095_LCN_PLUS();
        int[][] states = instance.longestCommonSubsequence(text1,text2,record);
        String lcsStr = instance.getLcsString(text1,text2,record);
        System.out.println("lcsLength="+states[text1.length()][text2.length()]);
        System.out.println("lcsStr="+lcsStr);

    }

    public int[][] longestCommonSubsequence(String text1, String text2,int[][] record) {
        if(null == text1 || text1.isEmpty() || null == text2 || text2.isEmpty()){
            return null;
        }

        int[][] states = new int[text1.length()+1][text2.length()+1];

        for(int i = 1; i <= text1.length();i++){
            for(int j = 1; j <= text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    states[i][j] = states[i-1][j-1] + 1;
                    // 0-表示往左上方回溯
                    record[i][j] = 1;
                }else if(states[i-1][j] > states[i][j-1]){
                    states[i][j] = states[i-1][j];
                    // -1 -表示往上方回溯
                    record[i][j] = 2;
                }else{
                    states[i][j] = states[i][j-1];
                    // 1 -表示往左方回溯
                    record[i][j] = 3;
                }
            }
        }

        return states;
    }

    public String getLcsString(String text1, String text2,int[][] record){
        String s = "";
        for(int i = 1; i <= text1.length();i++){
            for(int j = 1; j <= text2.length();j++){
                if(record[i][j] == 1){
                    s += text1.charAt(i-1);
                }
            }
        }

        return s;
    }
}
