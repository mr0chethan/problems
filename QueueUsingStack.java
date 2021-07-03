import java.util.Stack;
class QueueUsingStack{
    private Stack<Integer>stk=new Stack<>();
    private int peek;
    public int size(){
        return this.stk.size();
    }

    //add O(1) remove O(n)
    int peek(){
        return this.peek;
    }
    void add(int data){
        if(this.stk.size()==0){
            this.peek=data;
        }
        this.stk.push(data);
    }
    int remove(){
        Stack<Integer>temp=new Stack<>();
        int sizeBefore=this.stk.size();
        for(int i=0;i<sizeBefore;i++){
            temp.push(stk.pop());
        }
        int removed=temp.pop();
        int sizeAfter=temp.size();
        if(sizeAfter>0){
            this.peek=temp.peek();
        }
        for(int i=0;i<sizeAfter;i++){
            stk.push(temp.pop());
        }
        return removed;
    }
    //add O(n) remove O(1)
    // void add(int data){
    //     Stack<Integer>temp=new Stack<>();
    //     int sizeBefore=this.stk.size();
    //     for(int i=0;i<sizeBefore;i++){
    //         temp.push(stk.pop());
    //     }
    //     temp.push(data);
    //     int sizeAfter=temp.size();
    //     for(int i=0;i<sizeAfter;i++){
    //         stk.push(temp.pop());
    //     }
    // }
    // int remove(){
    //     return stk.pop();
    // }
    // int peek(){
    //     return stk.peek();
    // }

}