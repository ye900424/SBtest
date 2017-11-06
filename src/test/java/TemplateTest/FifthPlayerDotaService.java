package TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
public class FifthPlayerDotaService extends DotaAbstractTemplate{
    @Override
    public void selectHero() {
        System.out.println("");
    }

    @Override
    public void action() {
        System.out.println("买鸡包眼，送死背锅");
    }

    /**
     * 五号位玩家买装备
     * @return
     */
    @Override
    public String buyPorp() {
        return "小鸡，变鸟";
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.FIFTH_PLAYER;
    }
}
