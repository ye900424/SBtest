package bs;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 *
 * @author C.A.O
 * @date 2020/1/31
 */
public class ExcelTitle {


    public static void main(String[] args) {
        fun();
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int n) {
        StringBuffer result = new StringBuffer();
        while (n > 0) {
            int remainder = (n - 1) % 26;
            result.append(getChar(remainder));
            n = (n - 1) / 26;
        }
        return result.reverse().toString();
    }

    public static char getChar(int n) {
        char res = (char) (n + 65);
        return res;
    }

    public static void fun(){
        System.out.println((char)(33));
        System.out.println((int)Character.MIN_LOW_SURROGATE);
        System.out.println((int)Character.MAX_HIGH_SURROGATE);
    }

}
