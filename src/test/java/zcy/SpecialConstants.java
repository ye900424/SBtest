package zcy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caoyang on 2017/8/22.
 */
public class SpecialConstants {
    public static final Map<Integer, String> STATE = new HashMap<>();//审核状态

    public static final Integer STATE_MINUS_TEN = -10;//已删除
    public static final Integer STATE_MINUS_FIVE = -5;//上一流程结束创建下一流程待办

    public static final Integer STATE_ZERO = 0;//创建提交
    public static final Integer STATE_ZERO1 = 1;//撤销
    public static final Integer STATE_FIVE = 5;//修改提交(被退回后)
    public static final Integer STATE_TEN = 10;//单位负责人待同意
    public static final Integer STATE_TEN1 = 15;//单位负责人不同意
    public static final Integer STATE_TWENTY = 20;//待对方回复
    public static final Integer STATE_TWENTY1 = 25;//对方有异议
    public static final Integer STATE_THIRTY = 30;//待采购中心审核
    public static final Integer STATE_THIRTY1 = 35;//采购中心审核不通过
    public static final Integer STATE_FORTY = 40;//待财政审核
    public static final Integer STATE_FIFTY = 30;//财政审核不通过
    public static final Integer STATE_SIXTY = 45;//财政审核通过
}
