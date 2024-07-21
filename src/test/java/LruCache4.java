import java.util.HashMap;
import java.util.Map;

public class LruCache4 {
    public static void main(String[] args) {
        LruCache4 instance = new LruCache4(2);
        instance.put(1,1);
        instance.put(2,1);
        System.out.println(instance.get(1));
        instance.put(3,3);
        System.out.println(instance.get(2));
        instance.put(4,4);
        System.out.println(instance.get(1));
        System.out.println(instance.get(3));
        System.out.println(instance.get(4));
    }


    int capacity = 0;
    int count = 0;
    Map<Integer,Node> map = new HashMap();
    Node head;
    Node tail;

    public LruCache4(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }
    public void put(int key , int val){
        Node node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = val;
            moveToHead(node);
        }else{
            node = new Node(key,val);
            addToHead(node);
            map.put(key,node);
            count++;
            if(count > capacity){
                Node tail = removeTail();
                map.remove(tail.key);
                count--;
            }
        }
    }

    public Node removeTail(){
        Node tailPre = tail.pre;
        Node tailPrepre = tailPre.pre;
        tailPrepre.next = tail;
        tail.pre = tailPrepre;
        tailPre.next = null;
        tailPre.pre=null;
        return tailPre;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(Node node){
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        node.next = headNext;
        headNext.pre = node;
    }

    public void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }else{
            return -1;
        }
    }
}

class Node{
    int key;
    int val;
    Node next ;
    Node pre;
    public Node(){}
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
    public Node(int val,Node pre,Node next){
        this.val = val;
        this.pre=pre;
        this.next = next;
    }
}
