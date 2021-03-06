package zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jiangtao
 * @date 2018/11/12 上午10:00.
 */
public class MatcherTest {
    /**
     * emoji表情
     */
    private static final String EMOJI = "[\\uD83C\\uDC04-\\uD83C\\uDE1A]|[\\uD83D\\uDC66-\\uD83D\\uDC69]|" +
            "[\\uD83D\\uDC66\\uD83C\\uDFFB-\\uD83D\\uDC69\\uD83C\\uDFFF]|" +
            "[\\uD83D\\uDE45\\uD83C\\uDFFB-\\uD83D\\uDE4F\\uD83C\\uDFFF]|" +
            "[\\uD83C\\uDC00-\\uD83D\\uDFFF]|[\\uD83E\\uDD10-\\uD83E\\uDDC0]|" +
            "[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEF6]";

    /**
     * 特殊空格
     */
    private static final String SPECIAL_SPACE = "[\\uDBC0\\uDD11]";

    /**
     * 正则匹配,不能包含emoji表情和特殊空格
     * 参考 https://blog.csdn.net/MYsce/article/details/76546480
     */
    public static final String NOT_CONTAIN_SPECIAL_SYMBOLS = "^((?!" + SPECIAL_SPACE + "|" + EMOJI + ")(.|\\s))*?$";
    public static final String NOT_CONTAIN_SPECIAL_SYMBOLS_SIMPLE = "[\\s\\S]*";

    /**
     * 正则匹配,包含emoji表情和特殊空格
     */
    public static final String CONTAIN_SPECIAL_SYMBOLS = "(" + SPECIAL_SPACE + "|" + EMOJI + ")";


    public static void main(String[] args) {


        String source1 = "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                + "四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台四画面分割投影（在局域网内可同abc多台\n"
                ;


        String s = "▲性能要求 交换容量≥335Gbps,包转发率≥125Mpps，千兆光口≥24个，千兆combo口≥8，,万兆光口≥4个；配置双电源；\n" +
                "性能指标 MAC地址表≥16K；ACL≥1K\n" +
                "路由表容量≥1K（支持OSPF）\n" +
                "堆叠 最大堆叠台数>=9台\n" +
                "最大堆叠带宽>=80G（万兆上行主机）\n" +
                "可要求堆叠带宽>=80G（万兆上行主机），并要求实配接口的基础上额外满配堆叠带宽所需的接口和互联模块\n" +
                "支持跨设备链路聚合，单一IP管理，分布式弹性路由\n" +
                "支持通过标准以太端口进行堆叠（万兆或千兆均支持）\n" +
                "支持完善的堆叠分裂检测机制，堆叠分裂后能自动完成MAC和IP地址的重配置，无需手动干预\n" +
                "支持远程堆叠\n" +
                "▲ERPS 实现ERPS功能，\n" +
                "能够快速阻断环路，\n" +
                "链路收敛时间≤50ms，要求提供权威机构颁发的测试报告\n" +
                "CPU防护 实现CPU保护功能，能限制非法报文对CPU的攻击，保护交换机在各种环境下稳定工作，要求提供权威机构颁发的测试报告\n" +
                "VLAN特性 支持基于端口的VLAN，支持基于协议的VLAN；\n" +
                "支持基于MAC的VLAN；\n" +
                "最大VLAN数(不是VLAN ID)>=4094\n" +
                "链路聚合 支持最多8个端口聚合；支持最多128个聚合组（IRF2）；支持LACP\n" +
                "▲防雷 要求端口防雷等级≥10KV，提供官网截图链接证明；\n" +
                "镜像功能 支持本地端口镜像和远程端口镜像RSPAN；\n" +
                "支持流镜像\n" +
                "同时支持N：M的端口镜像（M大于1）\n" +
                "组播协议 支持IGMP v1/v2/v3，MLD v1/v2\n" +
                "支持IGMP Snooping v1/v2/v3，MLD Snooping v1/v2\n" +
                "支持PIM Snooping\n" +
                "支持MLD Proxy\n" +
                "支持组播VLAN\n" +
                "支持PIM-DM，PIM-SM，PIM-SSM\n" +
                "支持MSDP，MSDP for IPv6\n" +
                "支持MBGP，MBGP for Ipv6\n" +
                "路由协议 支持IPv4静态路由、RIP V1/V2、OSPF\n" +
                "支持IPv6静态路由、RIPng\n" +
                "支持IPv4和IPv6环境下的策略路由\n" +
                "可靠性 支持RRPP（快速环网保护协议），环网故障恢复时间不超过50ms；\n" +
                "支持Smartlink，收敛时间≤50ms\n" +
                "支持RSTP功能：收敛时间≤50ms\n" +
                "支持MSTP功能：收敛时间≤50ms\n" +
                "支持PVST功能：收敛时间≤50ms\n" +
                "管理和维护 支持SNMP V1/V2/V3、RMON、SSHV2\n" +
                " 支持OAM(802.1AG， 802.3AH)以太网运行、维护和管理标准\n" +
                "▲绿色节能 符合IEEE 802.3az（EEE）节能标准\n" +
                " 端口定时down功能（Schedule job）\n" +
                " 支持端口休眠，关闭没有应用的端口，节省能源\n" +
                " 支持智能风扇调速\n" +
                " 提供ROHS节能认证证书\n" +
                "▲其他要求 提供原厂三年质保授权函";

        String s1 = s;

        System.out.println("source : \n" + s1);

        test1(s1);
        System.out.println("==========");
        test2(s1);

    }


    public static void test1(String source) {
        Pattern pattern = Pattern.compile(NOT_CONTAIN_SPECIAL_SYMBOLS);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            System.out.println("不包含");
        } else {
            System.out.println("包含");
        }
    }

    public static void test2(String source) {
        Pattern pattern = Pattern.compile(CONTAIN_SPECIAL_SYMBOLS);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }
    }}




