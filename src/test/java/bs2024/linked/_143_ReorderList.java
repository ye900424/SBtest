package bs2024.linked;

public class _143_ReorderList {

    public static void main(String[] args) {
        _143_ReorderList instance = new _143_ReorderList();
        ListNode node = ListNode.create(6);
        instance.reorderList(node);
        System.out.println(node);
    }

    public void reorderList(ListNode head) {
        // 拆分链表，找到中点
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nodeR = slow.next;
        slow.next = null;

        // 反转后面的链表
        ListNode newHead = reverse(nodeR);

        // 合并链表
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur  = root;
        boolean tag = false;
        while(head != null && newHead != null){
            if(tag){
                cur.next = newHead;
                newHead = newHead.next;
            }else{
                cur.next = head;
                head = head.next;
            }
            cur = cur.next;
            tag = !tag;
        }

        cur.next = null == newHead ? head : newHead;
        head = root.next;
    }

    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
