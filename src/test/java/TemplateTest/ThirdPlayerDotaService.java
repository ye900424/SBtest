package TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
public class ThirdPlayerDotaService extends DotaAbstractTemplate{
    @Override
    public void action() {
        System.out.println("劣势路单，抗压");
    }

    /**
     * 三号位玩家买装备
     * @return
     */
    @Override
    public String buyPorp() {
        return "跳刀，推推";
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.THIRD_PLAYER;
    }
}
