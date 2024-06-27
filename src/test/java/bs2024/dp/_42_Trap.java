package bs2024.dp;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class _42_Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = new int[]{0,1,0,2,0,3};

        _42_Trap instance = new _42_Trap();
        int sum = instance.trap(height);
        System.out.println(sum);
    }

    public int trap(int[] height) {
        int sum = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }


        for (int i = 0; i < height.length; i++) {
            int min = Math.min(left_max[i], right_max[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }
}
