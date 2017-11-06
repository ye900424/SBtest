package TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
public class FirstPlayerDotaService extends DotaAbstractTemplate{


    @Override
    public void action() {
        System.out.printf("打钱，买装备，刷野，团战输出");
    }

    /**
     * 一号位玩家买装备
     * @return
     */
    @Override
    public String buyPorp() {
        return "飞鞋，点金，BKB，金箍棒，大炮，蝴蝶";
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.FIRST_PLAYER;
    }
}
