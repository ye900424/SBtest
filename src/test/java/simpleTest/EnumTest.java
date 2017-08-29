package simpleTest;

/**
 * Created by caoyang on 2017/7/24.
 */
public enum  EnumTest {

    AUCTION_ALL("2", "全部");

    private String wqa;
    private String asd;

    EnumTest(String a,String b){
        this.wqa = a;
        this.asd = b;
    }

    public String value() {
        return this.wqa;
    }


}
