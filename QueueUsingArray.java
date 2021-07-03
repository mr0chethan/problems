public class QueueUsingArray{
    private int[]arr;
    private int size;
    private int maxSize;
    private int front;
    private int back;
    protected void initialize(int len){
        this.arr=new int[len];
        this.size=0;
        this.maxSize=len;
        this.front=0;
        this.back=0;
    }
    QueueUsingArray(){
        initialize(5);
    }
    QueueUsingArray(int len)throws Exception{
        lengthNotPositiveException(len);
        initialize(len);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<this.size;i++){
            sb.append(this.arr[(this.front+i)%this.maxSize]);
            if(i<this.size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    private void lengthNotPositiveException(int len)throws Exception{
        if(len<=0){
            throw new Exception("lengthNotPositiveException: -1");
        }
    }
    public int size(){
        return this.size;
    }
    protected int maxSize(){
        return this.maxSize;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    private void queueIsEmptyException()throws Exception{
        if(this.size==0){
            throw new Exception("queueIsEmptyException: -1");
        }
    }
    private int peek_(){
        return this.arr[this.front];
    }
    public int peek()throws Exception{
        queueIsEmptyException();
        return peek_();
    }
    private int remove_(){
        int val=this.arr[this.front];
        this.arr[this.front]=0;
        this.front=(this.front+1)%this.maxSize;
        this.size--;
        return val;
    }
    public int remove()throws Exception{
        queueIsEmptyException();
        return remove_();
    }
    private void queueOverFlowException()throws Exception{
        if(this.size==this.maxSize){
            throw new Exception("queueOverFlowException: -1");
        }
    }
    private void add_(int val){
        this.arr[this.back]=val;
        this.back=(this.back+1)%this.maxSize;
        this.size++;
    }
    public void add(int val)throws Exception{
        queueOverFlowException();
        add_(val);
    }
}