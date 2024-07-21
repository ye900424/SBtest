package bs2024.dp;

import java.util.Arrays;
import java.util.Stack;

public class _300_lengthOfLIS {
    public static void main(String[] args) {
        _300_lengthOfLIS instance = new _300_lengthOfLIS();
        System.out.println(instance.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length +1];
        Arrays.fill(dp,1);

        int ret = 1;
        int temp = Integer.MIN_VALUE;
        for(int i = 1 ; i <= nums.length ; i++){
            for(int j = 1 ; j < i ; j++){
                if(nums[j-1] < nums[i-1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    ret = Math.max(ret,dp[i]);
                }
            }
        }


        return ret;
    }
}
