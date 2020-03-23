package fanxing;

/**
 * @author: C.A.O
 * @Description: 范型类测试
 * @Date: 2018/9/3
 */
public class Fun<T> {
    private T key;

    public Fun(){}

    public Fun(T key){
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getHash(){
        System.out.println(key.hashCode());
        return key.hashCode();
    }
}
