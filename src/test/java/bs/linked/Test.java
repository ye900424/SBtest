package bs.linked;

import com.google.common.collect.Lists;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test instance = new Test();
//        System.out.println(instance.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(instance.binarySearch(Lists.newArrayList(1,3,3,5),3));
        System.out.println(instance.binarySearch2(Lists.newArrayList(1,3,3,5),6));
    }

    // 查找大于等于target的第一个位置
    public int binarySearch(List<Integer> list,int target){
        int left = 0;
        int right = list.size() -1;
        while(left <= right){
            int mid = left +(right - left)/2;
            if(list.get(mid) <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return right;
    }

    public int binarySearch2(List<Integer> list,int target){
        int left = 0;
        int right = list.size() -1;
        while(left <= right){
            int mid = left +(right - left)/2;
            if(list.get(mid) >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList();

        for(int i = 0 ; i < nums.length ; i++){
            if(list.size() == 0){
                list.add(nums[i]);
            }else if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }else{
                int idx = binarySearch(list,nums[i]);
                if(idx >= list.size()){
                    list.add(nums[i]);
                }else{
                    list.set(idx,nums[i]);
                }
            }
        }

        return list.size();
    }



}
