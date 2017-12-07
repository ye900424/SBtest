package com.service.TemplateTest;

/**
 * Created by C.A.O on 2017/11/7.
 */
public class TestTem {

    public static void main(String[] args) {
        DotaAbstractTemplate dotaAbstractTemplate = new DotaAbstractTemplate() {
            @Override
            public void action() {
                System.out.println("gank成功");
            }

            @Override
            public String buyPorp() {
                return null;
            }

            @Override
            public PlayerType getPlayerType() {
                return null;
            }

            @Override
            public void selectHero() {
                System.out.println("选择弱币英雄：王思发");
            }
        };

        dotaAbstractTemplate.execute(1);
    }
}
