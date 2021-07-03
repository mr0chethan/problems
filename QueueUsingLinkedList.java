import java.util.LinkedList;
public class QueueUsingLinkedList{
    private LinkedList<Integer>ll=new LinkedList<>();
    public int size(){
        return ll.size();
    }
    public boolean isEmpty(){
        return ll.isEmpty();
    }
    private int peek_(){
        return ll.getFirst();
    }
    private void queueIsEmptyException()throws Exception{
        if(ll.size()==0){
            throw new Exception("queueIsEmptyException: -1");
        }
    }
    public int peek()throws Exception{
        queueIsEmptyException();
        return peek_();
    }
    public void add(int data){
        ll.addLast(data);
    }
    private int remove_(){
        return ll.removeFirst();
    }
    public int remove()throws Exception{
        queueIsEmptyException();
        return remove_();
    }
    @Override
    public String toString(){
        return ll.toString();
    }
}