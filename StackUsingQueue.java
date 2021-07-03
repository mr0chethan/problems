import java.util.*;
class StackUsingQueue{
    private ArrayDeque<Integer> suq=new ArrayDeque<>();
    int size(){
        return this.suq.size();
    }

    // push O(n) pop O(1)
    void push(int data)throws Exception{
        int sizeBefore=this.size();
        this.suq.add(data);
        for(int i=0;i<sizeBefore;i++){
            int temp=this.suq.remove();
            this.suq.add(temp);
        }  
    }
    int peek()throws Exception{
        return this.suq.peek();
    }
    int pop()throws Exception{
        return this.suq.remove();
    }

    //push O(1) pop O(n)
    // private int lastPushed;
    // void push(int data){
    //     this.lastPushed=data;
    //     this.suq.add(data);
    // }
    // int peek(){
    //     return this.lastPushed;
    // }

    // int pop(){
    //     int sizeBefore=this.size();
    //     for(int i=0;i<sizeBefore-1;i++){
    //         this.suq.add(this.suq.remove());
    //     }
    //     return this.suq.remove();
    // }
}