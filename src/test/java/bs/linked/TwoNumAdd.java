package bs.linked;

/**
 * @author C.A.O
 * @date 2020/3/11
 */
public class TwoNumAdd {
    int gw = 0;

    public static void main(String[] args) {
        TwoNumAdd instance = new TwoNumAdd();
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);


        instance.addTwoNumbers(listNode1,listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 直接遍历相加
        return add(l1,l2);
    }

    public ListNode add(ListNode l1,ListNode l2){
        int val1 ;
        int val2 ;
        if(l1 == null && l2 == null && gw == 0){
            return null;
        }else{
            val1 = (null == l1) ? 0 : l1.val;
            val2 = (null == l2) ? 0 : l2.val;

            int sum = val1 + val2  + gw;
            ListNode node = new ListNode(sum % 10);
            gw = (sum >= 10) ? 1 : 0;
            node.next = add((null == l1) ? null : l1.next,(null == l2) ? null : l2.next);
            return node;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
