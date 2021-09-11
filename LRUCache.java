import java.util.HashMap;
public class LRUCache {
    private int cap;
    private int size;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map;

    
    
    public class Node{
        public int key;
        public int val;
        public Node prev;
        public Node next;
        public Node(int key, int val,Node prev,Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node cur = this;
            while(cur!=null){
                sb.append(cur.val + ", ");
                cur = cur.next;
            }
            sb.append("]");     
            return sb.toString();
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while(cur!=null){
            sb.append(cur.val +", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Node removeNode(Node toRemove){
        if(toRemove == null)return toRemove;
        if(toRemove == this.head) return removeHeadNode();
        if(toRemove == this.tail) return removeTailNode();

        Node prevToRemove = toRemove.prev;
        Node nextToRemove = toRemove.next;
        toRemove.prev = null;
        toRemove.next = null;
        if(prevToRemove!=null){
            prevToRemove.next = nextToRemove;
        }
        if(nextToRemove!=null){
            nextToRemove.prev = prevToRemove;
        }
        this.size--;
        return toRemove;
    }

    public void addAfterTailNode(Node toAdd){
        if(toAdd == null)return;
        if(this.tail==null){
            toAdd.prev = toAdd.next = null; 
            this.head = this.tail = toAdd;
        }
        else{
            this.tail.next = toAdd;
            toAdd.prev = this.tail;
            this.tail = toAdd;
        }
        this.size++;
    }

    public Node removeHeadNode(){
        if(this.head == null) return head;
        Node headNext = head.next, ret = this.head;
        ret.next = null;
        if(headNext != null){
            headNext.prev = null;
        }
        else{
            this.tail = null;
        }
        this.head = headNext;
        this.size--;
        return ret;
    }

    public Node removeTailNode(){
        if(this.tail == null)return tail;
        Node tailPrev = tail.prev, ret = this.tail;
        ret.prev = null;
        if(tailPrev !=null){
            tailPrev.next = null;
        }
        else{
            this.head = null;
        }
        this.tail = tailPrev;
        this.size--;
        return ret;
    }
    

    public LRUCache(int cap) {
        this.cap = cap;
        this.map = new HashMap<>();
        this.head = tail = null;
        this.size = 0;
    }
    
    public int get(int key) {
        Node fromMap = this.map.get(key);
        int ret;
        if(fromMap == null){
            ret = -1;
        }
        else{
            removeNode(fromMap);
            addAfterTailNode(fromMap);
            ret = fromMap.val;
        }
            // System.out.println(this.map);
            // System.out.println(this.head);
        return ret;
    }
    
    public void put(int key, int value) {
        Node fromMap = this.map.get(key), toPut = fromMap;
        if(fromMap == null){
            toPut = new Node(key,value,null,null);
            if(this.size >= this.cap){
                this.map.remove(removeHeadNode().key);
            }
        }
        else{
            removeNode(fromMap);
            if(fromMap.val != value){
                fromMap.val = value;
            }
        }
        addAfterTailNode(toPut);
        this.map.put(key,toPut);
        // System.out.println(this.map);
        // System.out.println(this.head);
    }
}