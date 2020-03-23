package bs;

import java.util.LinkedList;

/**
 * @author C.A.O
 * @date 2020/1/7
 */
public class ListTest {
    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.linkedlistTest();
    }

    public void linkedlistTest(){
        LinkedList list = new LinkedList();

        list.offer(5);
        list.offer(2);
        list.offer(3);
        list.offer(6);
        list.offer(4);
        list.offer(1);

        while (list.size() > 0){
            System.out.println(list.remove());
        }
    }
}
