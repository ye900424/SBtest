package zcy;

/**
 * Created by caoyang on 2017/8/28.
 * 业务类型枚举类
 */
public enum PaBusinessTypeEnum {
    PROTOCOL(1,"协议供货"),
    INQUIRY(2,"在线询价"),
    CONTRACT(3,"合同");

    private Integer value;
    private String desc;


    private PaBusinessTypeEnum(Integer value,String desc){
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
