package bs2024.dp;

public class _64_minPathSum {
    public static void main(String[] args) {
        _64_minPathSum instance = new _64_minPathSum();
        System.out.println(instance.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1 ; i < m ; i++){
            dp[i][0] = dp[i-1][0]+ grid[i][0];
        }
        for(int i = 1; i < n ; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1] + grid[i][j]);
            }
        }

        return dp[m-1][n-1];
    }
}
