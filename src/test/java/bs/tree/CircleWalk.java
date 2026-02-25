package bs.tree;

public class CircleWalk {

    public static int countWays(int X, int n) {
        // 创建dp数组
        int[][] dp = new int[n + 1][X];

        // 初始化起始位置
        dp[0][0] = 1;

        // 填充dp表
        for (int step = 1; step <= n; ++step) {
            for (int pos = 0; pos < X; ++pos) {
                dp[step][pos] = dp[step - 1][(pos - 1 + X) % X] + dp[step - 1][(pos + 1) % X];
            }
        }

        // 返回走了n步回到0点的方法数
        return dp[n][0];
    }

    public static void main(String[] args) {
        int X = 12; // 圆环上的点数
        int n = 30; // 走的步数
        System.out.println("Number of ways to walk " + n + " steps back to 0: " + countWays(X, n));
        System.out.println("Number of ways to walk " + n + " steps back to 0: " + fun(X, n));
    }


    static int ret = 0 ;
    public static int fun(int x , int n){
        fun(x,n,0);
        return ret;
    }

    public static void fun(int x,int n , int path){
        if(n == 0){
            if(path % x == 0){
                ret = ret + 1;
            }
            return;
        }

        fun(x,n-1,path+1);
        fun(x,n-1,path-1);
    }
}
