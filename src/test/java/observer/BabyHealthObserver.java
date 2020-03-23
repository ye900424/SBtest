package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author C.A.O
 * @date 2019/8/26
 */
public class BabyHealthObserver implements Observer {

    private String name;
    private String role;

    public BabyHealthObserver(String name,String role){
        this.name = name;
        this.role = role;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Boolean){
            System.out.println(name+role+ "发现 宝宝 现在的身体状况是" + ((Boolean)arg ? "健康" : "生病中"));
        }
    }
}
