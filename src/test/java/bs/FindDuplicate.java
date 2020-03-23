package bs;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * <p>
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * @author C.A.O
 * @date 2020/2/1
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 4;

        FindDuplicate instance = new FindDuplicate();
        System.out.println(instance.findDuplicate1(arr));
    }

    /**
     * 普通遍历法
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        return erfen(nums, 1, nums.length - 1);
    }

    public int erfen(int[] arr, int min, int max) {

        if(min == max){
            return min;
        }

        // 计数器
        int count = 0;
        // 中间数
        int mid = (min + max) / 2;

        for (int i : arr) {
            if (i <= mid) {
                count++;
            }
        }
        if(count == mid){
            return erfen(arr,mid + 1,max);
        }else{
            return erfen(arr,min,mid);
        }
    }
}
