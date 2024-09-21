package bs2024.jiqiao;

import java.util.Arrays;

public class _31_Next {

    public static void main(String[] args){
        _31_Next instance = new _31_Next();
        int[] nums = new int[]{1,3,2};
        instance.nextPermutation(nums);

        Arrays.stream(nums).forEach(x-> System.out.println(x));

    }

    public void nextPermutation(int[] nums) {
        // 从后往前找第一个升序
        int x = -1;
        for(int i = nums.length - 1 ; i > 0 ; i--){
            if(nums[i - 1] < nums[i]){
                x = i -1;
                break;
            }
        }
        if(x == -1){
            reverse(nums,0,nums.length - 1);
            return;
        }


        // 从后往前找到第一个大于X的值
        int y = -1;
        for(int i = nums.length - 1 ; i > x ; i--){
            if(nums[i] > nums[x]){
                y = i;
                break;
            }
        }
        if(y != -1){
            swap(nums,x,y);
        }

        // 反转
        reverse(nums,x + 1,nums.length - 1);
    }

    public void reverse(int[] nums,int left, int right){
        while(left < right){
            swap(nums,left,right);
            left ++;
            right --;
        }
    }

    public void swap(int[] nums,int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
