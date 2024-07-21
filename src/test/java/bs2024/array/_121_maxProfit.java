package bs2024.array;

public class _121_maxProfit {
    public static void main(String[] args) {
        _121_maxProfit instance = new _121_maxProfit();
        System.out.println(instance.maxProfit(new int[]{2,1,2,1,0,1,2}));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0 ; i < prices.length ; i++){
            for(int j = i+1 ; j < prices.length ; j++){
                max = Math.max(max,prices[j] - prices[i]);
            }
        }
        return max;
    }
}
