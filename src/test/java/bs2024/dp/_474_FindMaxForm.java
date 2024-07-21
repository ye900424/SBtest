package bs2024.dp;

public class _474_FindMaxForm {

    public static void main(String[] args) {
        _474_FindMaxForm instance = new _474_FindMaxForm();
//        System.out.println(instance.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
        System.out.println(instance.findMaxForm(new String[]{"10", "00000", "111111", "111111", "111111"},5,3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;

        // 将如入参转化为0、1数量数组
        int[][] arr = new int[length][2];
        for(int i = 0 ; i < length ; i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            int zCount = 0;
            int oCount = 0;
            for(char c: chars){
                if(c - '0' == 0){
                    zCount++;
                }
                if(c - '0' == 1){
                    oCount++;
                }
            }
            arr[i][0] = zCount;
            arr[i][1] = oCount;
        }

        // 通过dp求解
        int[][] dp = new int[m + 1][n + 1];
        for(int[] sArr : arr){
            int zCount = sArr[0];
            int oCount = sArr[1];
            for(int i = m; i >= zCount ; i-- ){
                for(int j = n; j >=oCount ; j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - zCount][j - oCount] + 1);
                }
            }
        }
        return dp[m][n];

    }
}
