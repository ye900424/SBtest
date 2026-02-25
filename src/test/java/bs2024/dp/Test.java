package bs2024.dp;

import com.alibaba.fastjson.JSON;
import org.quartz.spi.ThreadExecutor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    int idx = 0;

    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.moveZeroes(new int[]{-1,0,1,2,-1,-4}));
        int[] nums = new int[]{2,2,2,2,2,1,4};
//        test.maxSlidingWindow(nums,3);
        print(test.canPartitionKSubsets(nums,3));
        print(test.idx);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 准备工作
        int max = 0;
        int sum = 0;
        int avg = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }

        avg = sum/k;
        if(max > avg || sum%k != 0){
            return false;
        }

        Arrays.sort(nums);
        reverse(nums,0,nums.length -1);

        // 回溯
        return backtrack(nums,k,0,avg,0,new boolean[nums.length]);
    }


    public boolean backtrack(int[] nums,int k, int sum,int avg,int start,boolean[] used){
        idx++;
        if(k == 0){
            return true;
        }

        if(sum == avg){
            return backtrack(nums,k-1,0,avg,0,used);
        }

        for(int i = start ; i < nums.length ; i++){
            if(sum + nums[i] > avg || used[i]){
                continue;
            }

            if(i>0 && !used[i-1] && nums[i] == nums[i-1]){
                continue;
            }

            used[i] = true;
            if(backtrack(nums,k,sum + nums[i],avg,i+1,used)){
                return true;
            }
            used[i] = false;
        }
        return false;
    }

    public void reverse(int nums[],int i ,int j){
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }

    public static void print(Object obj){
        System.out.println(JSON.toJSONString(obj));
    }
}
