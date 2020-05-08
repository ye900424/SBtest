package bs.DP;

import bs.array.ArrayUtil;

/**
 * 回溯法 对比 动态规划
 *
 * 一个m*n的矩阵，总左上角，往右下角，求最短路径
 *
 * @author C.A.O
 * @date 2020/3/30
 */
public class Test3 {
    public int minLen = Integer.MAX_VALUE;
    int[][] arr;


    public static void main(String[] args) {
        Test3 instance = new Test3();
        instance.arr = instance.create();
        instance.fun(0, 0, 0);
//        instance.fun3(0, 0, 0,instance.arr,3);
        System.out.println("最短路径：" + instance.minLen);

        // DP
        System.out.println(instance.fun2(instance.arr,4));
    }

    /**
     * 回溯法
     *
     * @param m
     * @param n
     * @param len
     */
    public void fun(int m, int n, int len) {

        if (m == 3 && n == 3 && len < minLen) {
            minLen = len;
            return;
        }
        if(n == 0 && m == 0){
            minLen = arr[0][0];
        }



        if (m < 3) {
            fun(m + 1, n, len + arr[m + 1][n]);
        }
        if (n < 3) {
            fun(m, n + 1, len + arr[m][n + 1]);
        }
    }


    /**
     * 动态规划
     *
     * @param matrix
     * @param n
     * @return
     */
    public int fun2(int[][] matrix, int n){
            int[][] states = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
                sum += matrix[0][j];
                states[0][j] = sum;
            }
            sum = 0;
            for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
                sum += matrix[i][0];
                states[i][0] = sum;
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 1; j < n; ++j) {
                    states[i][j] =
                            matrix[i][j] + Math.min(states[i][j-1], states[i-1][j]);
                }
            }
            return states[n-1][n-1];
    }


    public int[][] create() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            arr[i] = ArrayUtil.createIntArr(4);
        }
        return arr;
    }
}
