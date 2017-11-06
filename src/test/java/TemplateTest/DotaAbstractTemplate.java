package TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 */
public abstract class DotaAbstractTemplate implements DotaService{

    /**
     * 选择英雄
     */
    public void selectHero(){}

    /**
     * 分路
     */
    public void analyzeRoad(){}

    /**
     * 英雄的具体作战
     */
    public void execute(){
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
    public void end(){}


}
