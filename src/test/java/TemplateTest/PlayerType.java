package TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 */
public enum PlayerType {
    FIRST_PLAYER(1,"firstPlayer","一号位大哥，carry全场"),
    SECOND_PLAYER(2,"secondPlayer","二号位中单，秀操作，带节奏"),
    THIRD_PLAYER(3,"thirdPlayer","三号位劣单，劣势路抗压，一般为场控，玩家可为指挥者"),
    FOURTH_PLAYER(4,"fourthPlayer","四号位酱油，玩家可为指挥者"),
    FIFTH_PLAYER(5,"fifthPlayer","五号位酱油，买鸡包眼，背锅送死");

    Integer id;
    String code;
    String desc;


    PlayerType(Integer id, String code, String desc) {
        this.id = id;
        this.code = code;
        this.desc = desc;
    }
}
