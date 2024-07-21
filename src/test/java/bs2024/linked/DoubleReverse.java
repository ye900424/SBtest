package bs2024.linked;

public class DoubleReverse {
    public static void main(String[] args) {
        DoubleReverse instance = new DoubleReverse();
        instance.doReverse(ListNode.create(5)).toString();
    }

    public ListNode doReverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = head.next;
        head.next = doReverse(node.next);
        node.next = head;

        return node;
    }
}
