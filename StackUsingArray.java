public class StackUsingArray{
    protected int[]arr;
    private int size;
    private int maxSize;
    private int tos;
    protected void initialize(int len){
        this.arr=new int[len];
        this.maxSize=len;
        this.size=0;
        this.tos=-1;
    } 
    public StackUsingArray(){
        this.initialize(5);
    }
    public StackUsingArray(int len){
        this.initialize(len);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for(int i=this.tos;i>=0;i--){
            sb.append(this.arr[i]);
            if(i!=0){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    protected int maxSize(){
        return this.maxSize;
    }
    private void stackIsEmptyException()throws Exception{
        if(this.size==0){
            throw new Exception("stackIsEmptyException: -1");
        }
    }
    private void stackOverFlowException()throws Exception{
        if(this.size==this.maxSize){
            throw new Exception("stackOverFlowException: -1");
        }
    }
    private int top_(){
        return this.arr[this.tos];
    }
    public int top()throws Exception{
        this.stackIsEmptyException();
        return this.top_();
    }
    private void push_(int data){
        this.arr[++this.tos]=data;
        this.size++;
    }
    public void push(int data)throws Exception{
        this.stackOverFlowException();
        this.push_(data);
    }
    private int pop_(){
        int val=this.arr[this.tos];
        this.arr[this.tos]=0;
        this.tos--;
        this.size--;
        return val;
    }
    public int pop()throws Exception{
        this.stackIsEmptyException();
        return this.pop_();
    } 
}