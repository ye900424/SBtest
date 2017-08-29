package zcy;

/**
 * Created by caoyang on 2017/8/25.
 * 审批类型枚举类
 */
public enum PeculiarTypeEnum {
    INQUIRY_RESTART(1,"重新询价"),
    INQUIRY_CANCEL(2,"取消询价"),
    INQUIRY_CHANGE_SUPPLIER(3,"选择超过比例的次低供应商"),
    PROCOTOL_RESTART(4,"重新竞价"),
    PROTOCOL_CANCEL(5,"取消竞价"),
    CONTRACT_REFUSE(6,"合同拒签"),
    CONTRACT_CANCEL(7,"合同取消");


    private Integer value;
    private String desc;

    private PeculiarTypeEnum(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
