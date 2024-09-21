package bs2024.linked;

public class _160_xiangjiao {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        _160_xiangjiao instance = new _160_xiangjiao();
        System.out.println(instance.getIntersectionNode(node1,node4));
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 相交链表，走两遍肯定会在交点相遇
        ListNode A = headA;
        ListNode B = headB;
        while(true){
            if(A == B){
                return A;
            }
            A = A.next == null ? headB : A.next;
            B = B.next == null ? headA : B.next;
        }
    }
}
