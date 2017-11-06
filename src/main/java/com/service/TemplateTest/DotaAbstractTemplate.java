package com.service.TemplateTest;

import org.springframework.stereotype.Component;

/**
 * Created by C.A.O on 2017/11/3.
 */
@Component
public abstract class DotaAbstractTemplate implements DotaService{

    /**
     * 选择英雄
     */
    public void selectHero(){
        System.out.println("随机英雄");
    }

    /**
     * 分路
     */
    public void analyzeRoad(){
        System.out.println("随机分路");
    }

    /**
     * 英雄的具体作战
     */
    @Override
    public void execute(Integer i){
        this.selectHero();
        this.analyzeRoad();
        this.action();
        this.end();
    }

    /**
     * 行动
     */
    public abstract void action();

    /**
     * 战斗结束
     */
    public void end(){
        System.out.println("比赛正在进行");
    }


}
