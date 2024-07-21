package bs2024.linked;

public class TowNumSum {

    public static void main(String[] args) {
        TowNumSum instance = new TowNumSum();
        ListNode l1 = ListNode.create(9,9,9,9);
        ListNode l2 = ListNode.create(9,9,9,9,9,9);

        ListNode ret = instance.addTwoNumbers(l1,l2);
        ret.toString();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode tail = root;
        int temp = 0 ;

        while(l1 != null || l2 != null || temp != 0){
            int sum = (l1 == null ? 0 :l1.val) + (l2 == null ? 0 :l2.val) + temp;
            temp = sum / 10;
            ListNode cur = new ListNode(sum%10);
            tail.next = cur;
            tail = tail.next;

            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;
        }

        return root.next;
    }
}
