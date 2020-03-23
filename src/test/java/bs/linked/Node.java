package bs.linked;

/**
 * 链表
 * @author C.A.O
 * @date 2020/3/11
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val){
        this.val = val;
    }

    public static Node create(int size){
        Node head = new Node(0);
        Node cur = head;
        for(int i = 1 ; i < size ; i++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        return head;
    }

    public String toString(){
        String str = "";
        Node linkedList = this;
        int i = 0;
        while (linkedList != null && i<10){
            str += linkedList.val+"->";
            linkedList = linkedList.next;
            i++;
        }

        return str;

    }

}
