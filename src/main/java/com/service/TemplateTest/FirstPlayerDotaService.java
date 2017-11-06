package com.service.TemplateTest;

import org.springframework.stereotype.Service;

/**
 * Created by C.A.O on 2017/11/3.
 * 一号位玩家
 */
@Service

public class FirstPlayerDotaService extends DotaAbstractTemplate{

    @Override
    public void selectHero() {
        System.out.println("英雄选择：幽鬼");
    }

    @Override
    public void analyzeRoad() {
        System.out.println("分路选择：优势路");
    }

    @Override
    public void action() {
        System.out.println("打钱，买装备，刷野，团战输出");
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

    @Override
    public void end() {
        if (Math.random() > 0.5) {
            System.out.println("最终比赛赢了");
        } else {
            System.out.println("最终输了比赛");

        }
    }
}
