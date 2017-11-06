package com.service.TemplateTest;

/**
 * Created by C.A.O on 2017/11/3.
 * dota接口
 */
public interface DotaService {

    /**
     * 玩家具体操作
     */
    public void execute(Integer i);

    /**
     * 买装备
     * @return
     */
    public String buyPorp();

    /**
     * 返回枚举类型
     * @return
     */
    public PlayerType getPlayerType();
}
