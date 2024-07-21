package bs2024.sort;

import java.util.Arrays;

public class _75_sortColors {
    public static void main(String[] args) {
        _75_sortColors instance = new _75_sortColors();
        int[] nums = new int[]{2,0,1};
//        int[] nums = new int[]{2,0,2,1,1,0};
        instance.sortColors(nums);
        Arrays.stream(nums).forEach(x-> System.out.print(x));

    }

    public void sortColors(int[] nums) {
        int p0 = 0 ;
        int idx = 0 ;
        int p2 = nums.length - 1;

        while (idx <= p2){
            if(nums[idx] == 0){
                swap(nums,idx,p0);
                p0++;
                idx++;
            }else if(nums[idx] == 1){
                idx++;
            }else{
                swap(nums,idx,p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums ,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
