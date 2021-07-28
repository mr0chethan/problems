
public class HeapSort{
    public static void downHeapify(int[]arr, boolean isIncreasing, int parentIndex){
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

    public static void heapSort(int[]arr,boolean isIncreasing){
        for(int i=arr.length-1;i>=0;i--){
            downHeapify(arr, isIncreasing, i);
        }
    }
    public static void main(String[]args){

    }
}