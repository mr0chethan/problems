public class ArrayListMy{
    private int[]arr;
    private int size;
    private int maxSize;

    private void initialize(int maxSize){
        this.arr=new int[maxSize];
        this.size=0;
        this.maxSize=maxSize;
    }

    public ArrayList(){
        initialize(5);
    }
    public ArrayList(int maxSize){
        initialize(maxSize);
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public int size(){
        return this.size;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<this.size;i++){
            sb.append(arr[i]);
            if(i!=this.size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public void add(int data){
        if(this.size+1>this.maxSize){
            int[]oldArr=this.arr;
            this.maxSize*=2;
            this.arr=new int[maxSize];
            for(int i=0;i<oldArr.length;i++){
                arr[i]=oldArr[i];
            }
        }
        arr[this.size++]=data;
    }

    private void set_(int i,int data){
        arr[i]=data;
    }
    public void set(int i,int data) throws Exception{
        indexOutOfBoundException(i);
        set_(i,data);
    }
    
    private void indexOutOfBoundException(int i)throws Exception{
        if(i<0||i>=this.size){
            throw new Exception("indexOutOfBoundException: "+i+" sizeOfArrayListIs: "+this.size);
        }
    }
    private int get_(int i){
        return arr[i];
    }
    public int get(int i)throws Exception{
        indexOutOfBoundException(i);
        return get_(i);
    }
}