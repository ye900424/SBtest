package bs.linked;

/**
 * @author C.A.O
 * @date 2020/1/8
 */
public class Two_Two_Flip {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int data) {
            value = data;
        }

        public ListNode() {
        }
    }

    // 创建链表
    public static ListNode createLink(int arr[]) {
        ListNode head = null;
        ListNode p = null;
        ListNode tail = null;
        for (int i = 0; i < arr.length; i++) {
            p = new ListNode();
            p.value = arr[i];
            p.next = null;
            if (head == null) {
                head = p;
                tail = p;
            }
            tail = tail.next = p;
        }
        return head;
    }

    // 输出链表
    public static void printLink(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.value + " ");
        }
        System.out.println();
    }

    // 两两翻转链表
    public static ListNode filpList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = null, q = null, pre = null;
        for (p = head; p != null && p.next != null; p = p.next) {
            q = p.next;
            if (p == head) {
                p.next = q.next;
                q.next = p;
                head = q;
                pre = p;
            } else {
                pre.next = q;
                p.next = q.next;
                q.next = p;
                pre = p;
            }
        }
        return head;
    }

    public static ListNode swapPairs(ListNode head) {
        //递归出口
        if(head == null || head.next == null)
            return head;
        //每组相邻节点的第二个节点
        ListNode newNode = head.next;
        //每组相邻节点的第一个节点的next指针指向下一组已反转的第一个节点
        head.next = swapPairs(head.next.next);
        //每组相邻节点的第二个节点的next指针指向改组的第一个节点
        newNode.next = head;


//        ListNode next = head.next;
//        next.next = head;
//        head.next = swapPairs(head.next.next);


        return newNode;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 4, 7,6};
        ListNode head = createLink(arr);
        printLink(head);
//        head = filpList(head);
        head = swapPairs(head);


        printLink(head);

    }


}
