package chain.niubi;

import chain.base.Check;

/**
 * @author C.A.O
 * @date 2019/8/21
 */
public class Factory {
    public static Check Create(String className){
        try {
            return (Check) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
