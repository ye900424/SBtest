package observer;

/**
 * @author C.A.O
 * @date 2019/8/26
 */
public class Test {
    public static void main(String[] args) {
        Baby baby = new Baby("拖拖",true);

        BabyHealthObserver father = new BabyHealthObserver("曹阳","爸爸");
        BabyHealthObserver mather = new BabyHealthObserver("叶佳妮","妈妈");
        BabyHealthObserver grandma = new BabyHealthObserver("小红","奶奶");

        baby.addObserver(father);
        baby.addObserver(mather);
        baby.addObserver(grandma);

        baby.goToHospital(false);
        baby.goToHospital(true);

    }
}
