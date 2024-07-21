import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {

    public static void main(String[] args) {
        LRUCache3 instance = new LRUCache3(2);
        instance.put(2,1);
        instance.put(1,1);
        instance.put(2,3);
        instance.put(4,1);
        System.out.println(instance.get(1));
        System.out.println(instance.get(2));
    }

    static HashMap<Integer,Node> map = new HashMap<>();
    static Node head;
    static Node tail;

    private int capacity = 0;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1,null,null);
        tail = new Node(-1,-1,null,null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(null == node){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    // 这个可不写
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        Node node = new Node(key,value,head,head.next);
        addToHead(node);
        if(map.size()>=capacity){
            removeTail();
        }
        map.put(key,node);

    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }
    public void addToHead(Node node){
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        node.next = headNext;
        headNext.pre = node;
    }

    public void removeTail(){
        Node tailPre = tail.pre;
        tailPre.pre.next = tail;
        tail.pre = tailPre.pre;

        tailPre.pre = null;
        tailPre.next = null;

        map.remove(tailPre.key);
    }




    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key,int value,Node pre,Node next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}




