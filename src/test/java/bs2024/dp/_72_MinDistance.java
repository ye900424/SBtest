package bs2024.dp;

public class _72_MinDistance {

    public static void main(String[] args) {
        _72_MinDistance instance = new _72_MinDistance();
        System.out.println(instance.minDistance("horse","ros"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // 之所以初始化0~i，是因为假设一个单词长度为0时，另一个单词需要操作length步才能变过去
        for(int i = 0 ; i <=m ; i++){
            dp[i][0] = i;
        }
        for(int j = 0 ; j <=n ; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n ; j++){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = getMin(dp[i-1][j],dp[i][j-1] ,dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public int getMin(int x,int y, int z){
        return Math.min(Math.min(x,y),z);
    }
}
