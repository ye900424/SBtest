package bs2024.array;

public class _31_NextPermutation {
    public static void main(String[] args) {
        _31_NextPermutation instance = new _31_NextPermutation();
        instance.nextPermutation(new int[]{1,2,3,8,6,4,5,7});
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
