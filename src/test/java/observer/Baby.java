package observer;

import java.util.Observable;

/**
 * @author C.A.O
 * @date 2019/8/26
 */
public class Baby extends Observable {
    private Boolean isHealth;
    private String name;

    public Baby(String name,Boolean isHealth){
        this.isHealth = isHealth;
    }

    /**
     * 去医院检查
     */
    public void goToHospital(Boolean isHealth){
        this.isHealth = true;
        super.setChanged();
        super.notifyObservers(isHealth);
    }
}
