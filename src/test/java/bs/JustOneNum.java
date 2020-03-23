package bs;

/**
 * @author C.A.O
 * @date 2020/2/20
 */
public class JustOneNum {

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int j = nums.length - 1;
            while (j >= 0) {
                if (i != j && nums[i] == nums[j]) {
                    break;
                }
                j--;
            }

            if(j == -1){
                System.out.println(nums[i]);
                return nums[i];
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 2;
        nums[1] = 2;
        nums[2] = 1;

        JustOneNum justOneNum = new JustOneNum();
        justOneNum.singleNumber(nums);
    }
}
