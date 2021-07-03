public class StackUsingNode{
    public void push(int data){
        Node node=new Node(data);
        node.prev=this.top;
        this.top=node;
        this.size++;
    }
    public int peek(){
        return top.data;
    }
    public int pop(){
        int data=top.data;
        top=top.prev;
        this.size--;
        return data;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    private class Node{
        int data=0;
        Node prev=null;
        Node(int data){
            this.data=data;
        }
        Node(int data,Node prev){
            this.data=data;
            this.prev=prev;
        }
    }
    private Node top=null;
    private int size=0;
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        Node cur=this.top;
        while(cur!=null){
            sb.append(cur.data);
            if(cur.prev!=null){
                sb.append(", ");
            }
            cur=cur.prev;
        }
        sb.append("]");
        return sb.toString();
    }
}