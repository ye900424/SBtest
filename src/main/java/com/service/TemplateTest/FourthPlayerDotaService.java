package com.service.TemplateTest;

import org.springframework.stereotype.Service;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
@Service
public class FourthPlayerDotaService extends DotaAbstractTemplate{


    /**
     * 四号位玩家买装备
     * @return
     */
    @Override
    public String buyPorp() {
        return "眼，tp，推推，粉，雾";
    }


    @Override
    public PlayerType getPlayerType() {
        return PlayerType.FOURTH_PLAYER;
    }

    @Override
    public void action() {
        System.out.println("辅助插眼，占适量经济，作用很大");
    }
}
