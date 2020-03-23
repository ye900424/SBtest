import java.math.BigDecimal;

/**
 * @author C.A.O
 * @date 2019/11/6
 */
public class Test87 {
    public static void main(String[] args) {
        System.out.printf(calculatePrice(100L,"6.9").toString());
    }

    public static Long calculatePrice(Long originPrice, String subsidizedRate){
        BigDecimal origin = new BigDecimal(originPrice);
        BigDecimal subsidized = origin.multiply(new BigDecimal(subsidizedRate)).divide(new BigDecimal(100));
        BigDecimal target = origin.subtract(subsidized);
        return target.longValue();
    }
}
