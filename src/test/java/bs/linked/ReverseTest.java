package bs.linked;

/**
 * @author C.A.O
 * @date 2020/3/11
 */
public class ReverseTest {

    public static void main(String[] args) {
        ReverseTest instance = new ReverseTest();
        Node source = Node.create(5);
        System.out.println("反转前：" + source.toString());
        //        System.out.println("两两反转后：" + instance.reverse2(source).toString());
        System.out.println("反转后：" + instance.reverse(source).toString());


    }

    // 遍历反转
    public Node reverse(Node el){
        Node head = null;
        Node cur = el;
        Node pre = null;
        while (cur != null){
            Node next = cur.next;
            if(next == null){
                head = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return head;
    }

    // 递归反转
    public Node reverse1(Node el){
        if(el.next == null){
            return el;
        }
        Node head = reverse1(el.next);
        el.next.next = el;
        el.next = null;
        return head;
    }

    // 两两反转
    public Node reverse2(Node el){
        if(el == null || el.next == null){
            return el;
        }
        Node head = el.next;
        el.next = reverse2(el.next.next);
        head.next = el;
        return head;
    }


}
