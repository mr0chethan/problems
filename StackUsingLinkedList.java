import java.util.LinkedList;
public class StackUsingLinkedList{
    private LinkedList<Integer> ll=new LinkedList<>();
    public int size(){
        return ll.size();
    }
    public boolean isEmpty(){
        return ll.size()==0;
    }
    public void push(int data){
        ll.addFirst(data);
    }
    public int pop(){
        return ll.removeFirst();
    }
    public int peek(){
        return ll.getFirst();
    }
    @Override
    public String toString(){
        return ll.toString();
    }
}