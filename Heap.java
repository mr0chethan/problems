import java.util.ArrayList;
public class Heap{
    private ArrayList<Integer>arrayList=new ArrayList<>();
    public void display_(int parent){
        if(this.leftChild(parent)<this.size() && this.rightChild(parent)<this.size()){
            System.out.println(this.arrayList.get(this.leftChild(parent))+" <- "+this.arrayList.get(parent)+" -> "+this.arrayList.get(this.rightChild(parent)));
            display_(this.leftChild(parent));
            display_(this.rightChild(parent));
        }
        else if(this.leftChild(parent)<this.size()){
            System.out.println(this.arrayList.get(this.leftChild(parent))+" <- "+this.arrayList.get(parent)+" -> ");
            display_(this.leftChild(parent));
        }
        else if(this.rightChild(parent)<this.size()){
            System.out.println(" <- "+this.arrayList.get(parent)+" -> "+this.arrayList.get(this.rightChild(parent)));
            display_(this.rightChild(parent));
        }
        else{
            System.out.println(" <- "+this.arrayList.get(parent)+" -> ");
            return;
        }
    }
    public void display()throws Exception{
        heapIsEmptyException();
        display_(0);
    }
    private int parent(int child){
        return (child-1)/2;
    }
    private int leftChild(int parent){
        return 2*parent+1;
    }
    private int rightChild(int parent){
        return 2*parent+2;
    }
    private int lastLeaf(){
        return this.size()-1;
    }
    public int size(){
        return this.arrayList.size();
    }
    private void swap(int index1,int index2){
        int temp=this.arrayList.get(index1);
        this.arrayList.set(index1,this.arrayList.get(index2));
        this.arrayList.set(index2,temp);

    }
    private void upHeapify(int child){
        if(this.arrayList.get(child)<this.arrayList.get(this.parent(child))){
            this.swap(child,this.parent(child));
            child=this.parent(child);
            this.upHeapify(child);
        }        
    }
    public void add(int num){
        this.arrayList.add(num);
        int lastLeaf=this.lastLeaf();
        int child=lastLeaf;
        this.upHeapify(child);
    }
    private int peek_(){
        return this.arrayList.get(0);
    }
    private void heapIsEmptyException()throws Exception{
        if(this.size()==0){
            throw new Exception("heapIsEmptyException");
        }
    }
    public int peek()throws Exception{
        this.heapIsEmptyException();
        return this.peek_();
    }
    private void downHeapify(int parent){
        if((this.leftChild(parent)<this.size() && this.arrayList.get(parent)>this.arrayList.get(this.leftChild(parent))) || (this.rightChild(parent)<this.size() && this.arrayList.get(parent)>this.arrayList.get(this.rightChild(parent)))){
            if(this.leftChild(parent)<this.size() && this.rightChild(parent)<this.size() && this.arrayList.get(this.leftChild(parent)) < this.arrayList.get(this.rightChild(parent))){
                this.swap(parent,this.leftChild(parent));
                parent=this.leftChild(parent);
            }
            else{
                this.swap(parent,this.rightChild(parent));
                parent=this.rightChild(parent);
            }
            this.downHeapify(parent);
        }
    }
    private int remove_(){
        int removed=this.arrayList.get(0);
        int lastLeaf=this.lastLeaf();
        this.arrayList.set(0,this.arrayList.get(lastLeaf));
        this.arrayList.remove(lastLeaf);
        int parent=0;
        this.downHeapify(parent);
        return removed;
    }
    public int remove()throws Exception{
        this.heapIsEmptyException();
        return remove_();
    }
   
}