package JedisTest.ZcyLock;

/**
 * Created by C.A.O on 2018/1/19.
 */
public enum LockTypeEnum {
    TEST_TYPE("test_type","测试")


    ;
    private String code;
    private String remark;

    LockTypeEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }
}
