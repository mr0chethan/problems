public class DynamicQueue extends QueueUsingArray{
    DynamicQueue(){
        super();
    }
    DynamicQueue(int len)throws Exception{
        super(len);
    }
    @Override
    public void add(int data)throws Exception{
        if(super.size()==super.maxSize()){
            int[]temp=new int[super.size()];
            for(int i=0;i<temp.length;i++)temp[i]=super.remove();
            super.initialize(2*super.maxSize());
            for(int i=0;i<temp.length;i++)super.add(temp[i]);
        }
        super.add(data);
    }

}