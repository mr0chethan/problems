public class LinkedListUsingArray{
    private int[]arr;
    private int head;
    private int tail;
    private int size;
    private int maxSize;
    LinkedListUsingArray(){
        initialize(5);
    }
    LinkedListUsingArray(int maxSize)throws Exception{
        initialize(maxSize);
    }
    private void nonPositiveMaxSizeException(maxSize)throws Exception{
        if(maxSize<=0){
            throw new Exception("nonPositiveMaxSizeException: -1")
        }
    }
    private void initialize_(int maxSize){
        this.arr=new int[maxSize];
        this.maxSize=maxSize;
        this.head=-1;
        this.tail=-1;
        this.size=0;
    }
    private void initialize(int maxSize)throws Exception{
        nonPositiveMaxSizeException(maxSize)
        initialize_(maxSize);
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    private void linkedListIsEmptyException()throws Exception{
        if(this.size==0){
            throw new Exception("linkedListIsEmptyException");
        }
    }
    private void linkedListSizeOverFlowException()throws Exception{
        if(this.size==this.maxSize){
            throw new Exception("linkedListSizeOverFlowException")
        }
    }
    public addFirst_(){
        
    }
    public int addFirst()throws Exception{
        linkedListSizeOverFlowException();
        return addFirst_();
    }
}