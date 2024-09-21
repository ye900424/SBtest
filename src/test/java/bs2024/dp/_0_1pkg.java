package bs2024.dp;

public class _0_1pkg {
    public static void main(String[] args) {

        _0_1pkg instance = new _0_1pkg();
        System.out.println(instance.solveKnapsack(10,5,new int[]{3,1,4,11,12}));
    }

    public int solveKnapsack(int w, int n, int[] weights) {
        boolean dp[] = new boolean[w + 1];
        dp[0] = true;

        for(int i = 0 ; i < n ; i++){
            for(int j = w ; j >= weights[i]; j--){
                dp[j] = dp[j] || dp[j-weights[i]];
            }
        }

        int ret = -1;
        for(int i = w  ; i >=0 ;i--){
            if(dp[i]){
                return i;
            }
        }

        return ret;
    }
}
