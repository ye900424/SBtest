package bs.DP;

/**
 * @author C.A.O
 * @date 2020/3/23
 */
public class Test2 {

    public static void main(String[] args) {
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {10,15,20};
        Test2 test2 = new Test2();
        System.out.println( test2.minCostClimbingStairs(cost));
    }


        public int minCostClimbingStairs(int[] cost) {
            int f1 = 0, f2 = 0;
            for (int i = cost.length - 1; i >= 0; --i) {
                int f0 = cost[i] + Math.min(f1, f2);
                f2 = f1;
                f1 = f0;
            }
            return Math.min(f1, f2);
        }

}
