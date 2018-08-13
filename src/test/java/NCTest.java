/**
 * Created by C.A.O on 2018/7/9.
 * 已知过去十天股票的加个，计算出哪天买哪天卖收益最高
 */
public class NCTest {
    private static Integer[] prices = {10, 12, 11, 8, 10, 16, 3, 8, 15, 12};

    public static void main(String[] args) {
        Integer[][] dateAndInc = new Integer[10][10];

        for (int i = 0; i < prices.length; i++) {
            dateAndInc[i][i] = 0;
            setInc(dateAndInc, i, prices[i]);
        }

        for (int i = 0; i < dateAndInc.length; i++) {

            Integer[] price = dateAndInc[i];
            for (int j = 0; j < price.length; j++) {
                if (null != price[j]) {
                    System.out.println("第" + (i+1) + "天买入，第" + (j+1) + "天卖出，收益为" + price[j]);
                }
            }
        }
    }

    public static void setInc(Integer[][] indexAndInc, Integer date, Integer price) {
        for (int i = 0; i < date; i++) {
            indexAndInc[i][date] = price - prices[i];
        }
    }
}
