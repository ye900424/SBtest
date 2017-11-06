package TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
public class SecondPlayerDotaService extends DotaAbstractTemplate{

    @Override
    public void action() {
        System.out.println("中单带节奏，gank，后期承担第二输出");
    }

    /**
     * 二号位玩家买装备
     * @return
     */
    @Override
    public String buyPorp() {
        return "假腿，bkb，羊刀，瓶子，林肯";
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.SECOND_PLAYER;
    }
}
