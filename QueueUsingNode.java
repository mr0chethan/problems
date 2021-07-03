public class QueueUsingNode{
    private class Node{
        public int data;
        public Node next;
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        Node(int data){
            this.data=data;
            this.next=null;
        }
        Node(){
            this.data=0;
            this.next=null;
        }
    }
    private Node front;
    private Node back;
    private int size;
    QueueUsingNode(){
        this.front=null;
        this.back=null;
        this.size=0;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void add(int data){
        Node node=new Node(data);
        if(this.size==0){
            this.front=node;
            this.back=node;
        }
        else{
            this.back.next=node;
            this.back=node;
        }
        this.size++;
    }
    private void queueIsEmptyException()throws Exception{
        if(this.size==0){
            throw new Exception("queueIsEmptyException: -1");
        }
    }
    private int peek_(){
        return this.front.data;
    }
    public int peek() throws Exception{
        queueIsEmptyException();
        return peek_();
    }
    private int remove_(){
        Node node=this.front;
        int data=node.data;
        front=node.next;
        node.next=null;
        return data;
    }
    public int remove()throws Exception{
        queueIsEmptyException();
        return remove_();
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        Node cur=this.front;
        while(cur!=null){
            sb.append(cur.data);
            if(cur.next!=null){
                sb.append(", ");
            }
            cur=cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

}