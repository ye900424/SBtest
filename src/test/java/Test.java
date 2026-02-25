public class Test{
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Test instance = new Test();
        ListNode result = instance.reverseByK(node1,4);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    // 每K个反转
    ListNode pre ;
    ListNode end ;
    public ListNode reverseByK(ListNode head,int k){
        // 定义守护节点
        ListNode root = new ListNode(-1,head);
        pre = root;
        end = root;

        while(true){
            for(int i = 0 ; i < k ; i++){
                end = end.next;
                if(end == null){
                    // 拆分链表
//                    ListNode start = pre.next;
//                    ListNode next = end.next;
//
//                    pre.next = null;
//                    end.next = null;
//
//                    // 反转
//                    ListNode reverseNode = reverse(start);
//
//                    pre.next = reverseNode;
//                    start.next = next;
                    break;
                }
            }
            if(end == null){
                break;
            }

            // 拆分链表
            ListNode start = pre.next;
            ListNode next = end.next;

            pre.next = null;
            end.next = null;

            // 反转
            ListNode reverseNode = reverse(start);

            pre.next = reverseNode;
            start.next = next;

            pre = start;
            end = start;
        }

        ListNode start = pre.next;
        ListNode reNode = reverse(start);
        pre.next = reNode;

        return root.next;
    }

    // 链表反转
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }


    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val,ListNode node){
            this.val = val;
            this.next = node;
        }
    }
}
