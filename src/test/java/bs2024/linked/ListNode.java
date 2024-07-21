package bs2024.linked;

import bs.linked.Node;

public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode create(int size){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 1 ; i < size ; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        head.toString();
        return head;
    }

    public static ListNode create(int... args){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i : args){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        head.next.toString();
        return head.next;
    }

    public String toString(){
        String str = "";
        ListNode linkedList = this;
        int i = 0;
        while (linkedList != null){
            str += linkedList.val+"->";
            linkedList = linkedList.next;
            i++;
        }

        System.out.println(str);

        return str;
    }
}
