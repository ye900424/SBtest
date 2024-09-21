package bs2024.array;

public class _41_fFrstMissingPositive {

    public static void main(String[] args) {
        _41_fFrstMissingPositive instance = new _41_fFrstMissingPositive();
        System.out.println(instance.firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            while(nums[i] != i+1 && nums[i]-1 >= 0 && nums[i]-1 < nums.length && nums[nums[i]-1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return -1;

    }
}
