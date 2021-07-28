import java.util.LinkedList;

public class HashMapSir{
    private class HashMapSirNode{
        Integer key;
        Integer value;
         HashMapSirNode(Integer key,Integer value){
            this.key=key;
            this.value=value;
        }
    }
    private LinkedList<HashMapSirNode>[]buckets;
    private int numberOfKeys;
    HashMapSir(){
        initializeBuckets(10);
    }
    private void initializeBuckets(int bucketsSize){
        buckets=new LinkedList[bucketsSize];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
        }
        this.numberOfKeys=0;
    }
    private int getHashCode(Integer key){
        return key.hashCode();
    }
    private int getGroup(Integer key){
        int hashCode=getHashCode(key);
        return Math.abs(hashCode) % this.buckets.length;
    }
    private boolean containsKey(Integer key){
        int groupIndex=getGroup(key);
        LinkedList<HashMapSirNode>groupLinkedList=buckets[groupIndex];
        int i=groupLinkedList.size();
        while(i-->0){
            HashMapSirNode hashMapSirNode=groupLinkedList.removeFirst();
            if(hashMapSirNode.key==key)return true;
            groupLinkedList.addLast(hashMapSirNode);
        }
        return false;
    }
    public Integer get(Integer key){
        int groupIndex=getGroup(key);
        LinkedList<HashMapSirNode>groupLinkedList=buckets[groupIndex];
        int i=groupLinkedList.size();
        while(i-->0){
            HashMapSirNode hashMapSirNode=groupLinkedList.removeFirst();
            groupLinkedList.addLast(hashMapSirNode);
            if(hashMapSirNode.key==key)return hashMapSirNode.value;
        }
        return null;
    }
    public Integer remove(Integer key){
        int groupIndex=getGroup(key);
        LinkedList<HashMapSirNode>groupLinkedList=buckets[groupIndex];
        int i=groupLinkedList.size();
        while(i-->0){
            HashMapSirNode hashMapSirNode=groupLinkedList.removeFirst();
            if(hashMapSirNode.key==key)return hashMapSirNode.value;
            groupLinkedList.addLast(hashMapSirNode);
        }
        return null;
    }
    public Integer getOrDefault(Integer key, Integer def){
        Integer valueGot=get(key);
        if(valueGot!=null){
            return valueGot;
        }
        return def;
    }
    
}
















// public void put(Integer key,Integer value){
//     int groupIndex=get(key);
//     int indexInBucket=this.indexInBucket(key,indexOfBucket);
//     if(indexInBucket==-1){
//         buckets[indexOfBucket].addLast(new HashMapNode(key,value));
//         this.size++;
//     }
//     else{
//         buckets[indexOfBucket].get(indexInBucket).value=value;
//     }
// }