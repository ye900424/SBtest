package com.service.TemplateTest;

import org.springframework.stereotype.Service;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
@Service
public class FifthPlayerDotaService extends DotaAbstractTemplate {
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
     *
     * @return
     */
    @Override
    public String buyPorp() {
        return "小鸡，变鸟";
    }

    @Override
    public void end() {
        if (Math.random() > 0.5) {
            System.out.println("最终比赛赢了");
        } else {
            System.out.println("最终输了比赛");

        }
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.FIFTH_PLAYER;
    }


    public static void main(String[] args) {
        System.out.println(Math.random());
    }
}
