public class LinkedListUsingNodeWithOutTail{
    private class Node {
        int data = 0;
        Node next=null;
        Node(int data) {
            this.data = data;
        }
    }
    private Node head = null;
    private int size = 0;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = this.head;
        while(cur != null){
            sb.append(cur.data);
            if(cur.next != null){
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    private void addFirstNode(Node node) {
        node.next = this.head;
        this.head = node;
        this.size++;
    }
    public void addFirst(int data){
        Node node =new Node(data);
        this.addFirstNode(node);
    }
    private void addLastNode(Node node){
        if(this.size==0){
            this.head=node;
        }
        else{
            Node cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
        this.size++;
    }
    public void addLast(int data){
        Node node=new Node(data);
        this.addLastNode(node);
    }
    private void addNodeAt(int idx,Node node){
        if(idx==0){
            this.addFirstNode(node);
            return;
        }
        else if(idx==this.size){
            this.addLastNode(node);
            return;
        }
        Node prevNode=this.getNodeAt(idx-1);
        Node forwNode=prevNode.next;
        node.next=forwNode;
        prevNode.next=node;
        this.size++;
    }
    public void addAt(int idx,int data){
        if(idx<0 || idx>this.size){
            return;
        }
        Node node=new Node(data);
        this.addNodeAt(idx,node);
    }
    private Node removeFirstNode(){
        Node firstNode=this.head;
        this.head=firstNode.next;
        if(firstNode.next!=null){
            firstNode.next=null;
        }
        this.size--;
        return firstNode;
    }
    public int removeFirst(){
        if(this.size==0){
            return -1;
        }
        Node firstNode=this.removeFirstNode();
        return firstNode.data;
    }
    private Node removeLastNode(){
        if(this.size==1){
            Node lastNode=this.head;
            this.head=null;
            this.size--;
            return lastNode;
        }
        else{
            Node prevLastNode=this.getNodeAt(this.size-2);
            Node lastNode=prevLastNode.next;
            prevLastNode.next=null;
            this.size--;
            return lastNode;
        }
    }
    
    public int removeLast(){
        if(this.size==0){
            return -1;
        }
        Node lastNode=this.removeLastNode();
        return lastNode.data;
    }
    private Node removeNodeAt(int idx){
        if(idx==0){
            return this.removeFirstNode();
        }
        else if(idx==this.size-1){
            return this.removeLastNode();
        }
        Node prevNode=this.getNodeAt(idx-1);
        Node node=prevNode.next;
        Node forwNode=node.next;
        prevNode.next=forwNode;
        node.next=null;
        this.size--;
        return node;
    }
    
    public int removeAt(int idx){
        if(idx<0 || idx>=this.size){
            return -1;
        }
        Node node=this.removeNodeAt(idx);
        return node.data;
    }
    private Node getFirstNode(){
        Node firstNode=this.head;
        return firstNode;
    }
    
    public int getFirst(){
        if(size==0){
            return -1;
        }
        Node firstNode=this.getFirstNode();
        return firstNode.data;
    }
    private Node getLastNode(){
        Node cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        Node lastNode=cur;
        return lastNode;
    }

    public int getLast(){
        if(this.size==0){
            return -1;
        }
        Node lastNode=this.getLastNode();
        return lastNode.data;
    }
    private Node getNodeAt(int idx){
        if(idx==0){
            return this.getFirstNode();
        }
        else if(idx==this.size-1){
            return this.getLastNode();
        }
        Node cur=this.head;
        while(idx-->0){
            cur=cur.next;
        }
        return cur;
    }
    
    public int getAt(int idx){
        if(idx<0 || idx>=this.size){
            return -1;
        }
        Node node=this.getNodeAt(idx);
        return node.data;

    }
}