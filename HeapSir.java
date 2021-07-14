import java.util.ArrayList;

public class HeapSir{
    private ArrayList<Integer>arr;
    private int numberOfElements=0;
    private boolean isMaxHeap=true;

    private void initialize(boolean isMaxHeap){
        this.arr=new ArrayList<>();
        this.isMaxHeap=isMaxHeap;
        this.numberOfElements=0;

    }
    public HeapSir(boolean isMaxHeap){
        initialize(isMaxHeap);
    }
    public HeapSir(){
        this(true);
    }
    public HeapSir(int[]data,boolean isMaxHeap){
        this(isMaxHeap);
        for(int num:data){
            this.arr.add(num);
        }
        for(int i=arr.size()-1;i>=0;i--){
            downHeapify(i);
        }
    }
    private void heapUnderFlowException()throws Exception{
        if(this.numberOfElements==0){
            throw new Exception("heapUnderFlowException");
        }
    }
    public int compareTo(int thisIndex,int otherIndex){
        if(!this.isMaxHeap){
            return this.arr.get(thisIndex)-this.arr.get(otherIndex);
        }
        else{
            return this.arr.get(otherIndex)-this.arr.get(thisIndex);
        }
    }
    private void swap(int i,int j){
        int numI=this.arr.get(i);
        int numJ=this.arr.get(j);
        this.arr.set(i,numJ);
        this.arr.set(j,numI);
    }

    private void downHeapify(int parentIndex){
        int leftChildIndex=2*parentIndex+1;
        int rightChildIndex=2*parentIndex+2;
        int maxIndex=parentIndex;
        if(leftChildIndex<this.numberOfElements && compareTo(maxIndex,leftChildIndex)>0){
            maxIndex=leftChildIndex;
        }
        if(rightChildIndex<this.numberOfElements && compareTo(maxIndex,rightChildIndex)>0){
            maxIndex=rightChildIndex;
        }
        if(parentIndex!=maxIndex){
            swap(parentIndex,maxIndex);
            downHeapify(maxIndex);
        }
    }

    private void upHeapify(int childIndex){
        int parentIndex=(childIndex-1)/2;
        if(parentIndex>=0 && compareTo(childIndex,parentIndex)<0){
            swap(childIndex,parentIndex);
            upHeapify(parentIndex);
        }
    }

    public int peek() throws Exception{
        heapUnderFlowException();
        return this.arr.get(0);
    }

    public int remove() throws Exception{
        heapUnderFlowException();
        int removed=this.arr.get(0);
        swap(0,this.numberOfElements-1);
        this.arr.remove(this.numberOfElements-1);
        this.numberOfElements--;
        downHeapify(0);
        return removed;
    }
    public void add(int data){
        this.arr.add(data);
        upHeapify(this.numberOfElements);
        this.numberOfElements++;
    }
    

}