package bs2024.dp;

public class _416_CanPartition {

    public static void main(String[] args) {
        _416_CanPartition instance = new _416_CanPartition();

        System.out.println(instance.canPartition(new int[]{2,2,3,5}));
        System.out.println(instance.canPartition2(new int[]{2,2,3,5}));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
//        for (int i = 0; i < n; i++) {
//            int num = nums[i];
////            for (int j = target; j >= num; --j) {
////                dp[j] |= dp[j - num];
////            }
//            for (int j = num; j <=target; j++) {
//                dp[j] |= dp[j - num];
//            }
//        }

        for(int i = 1 ; i < nums.length  ; i++){
            for(int j = nums[i] ; j <= target ; j--){
                dp[j] |= dp[j - nums[j]];
            }
        }

//        for(int i = 1; i < dp.length ; i++){
//            for(int j = 0 ; j < nums.length -1 ; j++){
//                if(nums[j] > target){
//                    return false;
//                }
//                if(i - nums[j] >= 0 && dp[i - nums[j]] ){
//                    dp[i] = true;
//                }
//            }
//        }
        return dp[target];
    }

    public boolean canPartition2(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        int sum = 0 ;
        for(int i : nums){
            sum += i;
        }
        if((sum & 1) == 1){
            return false;
        }

        int target = sum/2;
        boolean[] states = new boolean[target + 1];
        states[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                states[j] |= states[j - num];
            }
        }

        return states[target];
    }

}
