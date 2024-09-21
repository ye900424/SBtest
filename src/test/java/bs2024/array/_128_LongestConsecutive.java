package bs2024.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _128_LongestConsecutive {
    public static void main(String[] args) {
        _128_LongestConsecutive instance = new _128_LongestConsecutive();
        System.out.println(instance.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        Set<Integer> set = new HashSet();
        // 放入set
        for(Integer el : nums){
            set.add(el);
        }

        int ret = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(set.contains(nums[i] - 1)){
                continue;
            }

            int temp = 0;
            int el = nums[i];
            while(set.contains(el)){
                temp ++;
                el ++;
            }
            ret = Math.max(ret,temp);
        }

        return ret;
    }
}
