public class DynamicStack extends StackUsingArray{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int len){
        super(len);
    }
    @Override
    public void push(int data)throws Exception{
        if(super.size()==super.maxSize()){

            // StackUsingArray temp=this;
            // System.out.println(temp.toString());
            // super.initialize(2*super.maxSize());
            // System.out.println(temp.toString());
            // while(temp.size()!=0)super.push(temp.pop());


            // int[] temp=super.arr;
            // super.initialize(2*super.maxSize());
            // for(int i=0;i<temp.length;i++)super.push(temp[i]);

            int[]temp=new int[super.size()];
            int i=0;
            while(super.size()!=0)temp[i++]=super.pop();
            super.initialize(2*super.maxSize());
            while(--i>0)super.push(temp[i]);
        }
        super.push(data);
    } 
    
}