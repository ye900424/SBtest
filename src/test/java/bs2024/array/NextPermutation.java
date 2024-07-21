package bs2024.array;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation instance = new NextPermutation();
        int[] nums = new int[]{3, 2, 1};
        instance.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        // 找到第一个 相邻升序
        int x = -1;
        int y = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                x = i - 1;
                break;
            }
        }

        // 找到 x 后面大于x的最小的数字下标
        if (x != -1) {
            int minmax = Integer.MAX_VALUE;
            ;
            for (int i = x + 1; i < nums.length; i++) {
                if (nums[i] > nums[x] && nums[i] < minmax) {
                    minmax = nums[i];
                    y = i;
                }
            }
        }

        // 交换x\y的值
        if (x != -1 && y != -1) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }


        // x后面的升序排列
        for (int i = x + 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
