package bs2024.linked;

public class _93_reverseBetween {

    public static void main(String[] args) {
        _93_reverseBetween instance = new _93_reverseBetween();

        ListNode head = ListNode.create(5);
        ListNode reversoNode = instance.reverseBetween(head,1,5);
        reversoNode.toString();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 确定头节点
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode pre = root;
        for(int i = 0 ; i < left -1 ; i++){
            pre = pre.next;
        }

        ListNode rightNode = root;
        for(int i = 0 ; i < right ; i++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode succNode = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        ListNode reverseNode = doReverse(leftNode);

        pre.next = reverseNode;
        leftNode.next = succNode;

        return root.next;
    }

    public ListNode doReverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode head = doReverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}
