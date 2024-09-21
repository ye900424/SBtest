package bs2024.dp;

public class _221_MaximalSquare {
    public static void main(String[] args) {
        _221_MaximalSquare instance = new _221_MaximalSquare();
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(instance.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int ret = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(matrix[i-1][j-1] - '0' == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    ret = Math.max(ret,dp[i][j]);
                }
            }
        }

        return ret*ret;
    }

}
