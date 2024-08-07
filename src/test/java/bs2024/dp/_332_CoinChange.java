package bs2024.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class _332_CoinChange {
    public static void main(String[] args) {
        _332_CoinChange instance = new _332_CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(instance.coinChange(coins,amount));
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }

        // 定义状态
        int[] states = new int[amount + 1];
        // 初始化
        for(int i = 0 ; i < states.length ; i++){
            // 假设 初始值 为一个不可能的大数
            states[i] = amount + 1;
        }
        // 0元肯定要设置为 0枚硬币，这个很重要
        states[0] = 0;

        for(int i = 1; i <= amount ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                if(i >= coins[j]){
                    // 转移方程很关键！！！
                    states[i] = Math.min(states[i],states[i-coins[j]] + 1);
                }
            }
        }

        return states[amount] > amount ? -1 : states[amount];

    }

//    public int coinChange(int[] coins, int amount) {
//        // 自底向上的动态规划
//        if(coins.length == 0){
//            return -1;
//        }
//
//        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
//        int[] memo = new int[amount+1];
//        memo[0] = 0;
//        for(int i = 1; i <= amount;i++){
//            int min = Integer.MAX_VALUE;
//            for(int j = 0;j < coins.length;j++){
//                if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
//                    min = memo[i-coins[j]] + 1;
//                }
//            }
//            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
//            memo[i] = min;
//        }
//
//        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
//    }
}
