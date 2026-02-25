import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class LRUCache {

    Map<Integer,ListNode> cache ;
    ListNode head ;
    ListNode tail;
    int capacity;
    ScheduledThreadPoolExecutor schedule;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.pre = head;
        cache = new ConcurrentHashMap(capacity);
        schedule = new ScheduledThreadPoolExecutor(1);

        schedule.scheduleAtFixedRate(()->{
            for(Map.Entry<Integer,ListNode> cache : cache.entrySet()){
                int key = cache.getKey();
                ListNode node = cache.getValue();
                if(node.expireTime > new Date().getTime()){
                    // todo by caoyang
                }
            }
        },1,1, TimeUnit.SECONDS);
    }

    public int get(int key) {
        synchronized(cache){
            ListNode node = cache.get(key);
            if(null != node){
                node.expireTime = new Date().getTime() + 1000;
                remove(node);
                addHead(node);
                return node.val;
            }else{
                return -1;
            }
        }

    }

    public void put(int key, int value) {
        synchronized(cache){
            ListNode node = cache.get(key);
            if(node == null){
                node = new ListNode(key,value,new Date().getTime() + 1000);
                if(cache.size() >= capacity){
                    ListNode tempNode = tail.pre;
                    remove(tempNode);
                    cache.remove(key);
                    addHead(node);
                }
            }else{
                node.val = value;
                node.expireTime = new Date().getTime() + 1000;
                remove(node);
                addHead(node);
            }
        }

    }

    public void remove(ListNode node){
        ListNode pre = node.pre;
        ListNode next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    public void addHead(ListNode node){
        ListNode headNext = head.next;

        head.next = node;
        node.next = headNext;

        headNext.pre = node;
        node.pre = head;
    }

    class ListNode{
        private int key;
        private int val;
        private ListNode pre;
        private ListNode next;
        private long expireTime;

        public ListNode(){}

        public ListNode(int key , int val){
            this.key = key;
            this.val = val;
        }

        public ListNode(int key , int val, long expireTime){
            this.key = key;
            this.val = val;
        }

    }
}