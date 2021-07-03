import java.util.LinkedList;
import java.util.ArrayList;
public class HashMap<KeyDataType,ValueDataType>{
    private class HashMapNode{
        KeyDataType key;
        ValueDataType value;
        private HashMapNode(KeyDataType key,ValueDataType value){
            this.key=key;
            this.value=value;
        }
    }
    private LinkedList<HashMapNode>[]buckets;
    public HashMap(){
        initializeBuckets(this.initialBucketsSize);
    }
    private void initializeBuckets(int bucketsSize){
        buckets=new LinkedList[bucketsSize];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
        }
        this.size=0;
        this.lambda=0.0;
    }
    private int size;
    private double lambda;
    private int initialBucketsSize=4;
    private double loadingFactor=3.0;
    private double minimumLoadingFactor=1.0;
    // private int wordSize=8;
    // private int highestPrimeNumberNotHigherThanBucketsSize=this.highestPrimeNumberNotHigherThanBucketsSize();
    // private int leastPrimeNumberNotLesserThanBucketSize=this.leastPrimeNumberNotLesserThanBucketSize();
    private int bucketsSize(){
        return this.buckets.length;
    }
    // private boolean isPrime(int num){
    //     for(int i=2;i*i<=num;i++){
    //         if(num % i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // private int highestPrimeNumberNotHigherThanBucketsSize(){
    //     for(int i=this.bucketsSize();i>=2;i--){
    //         if(isPrime(i)){
    //             return i;
    //         }
    //     }
    //     return 2;
    // }
    // private int leastPrimeNumberNotLesserThanBucketSize(){
    //     int i=this.bucketsSize();
    //     while(true){
    //         if(isPrime(i)){
    //             return i;
    //         }
    //         i++;
    //     }
    // }
    // public int hashCodeDivision(int key){
    //     return key % this.highestPrimeNumberNotHigherThanBucketsSize;
    // }
    // public int hashCodeMultiplication(int key){
    //     // return (((int)this.leastPrimeNumberNotLesserThanBucketSize*key) & 11111111) >> (this.wordSize-this.bucketsSize()); //& 1111111111111111111111111111111111111111111111111111111111111111 //&1111111111
    //     return (int)Math.floor( ( (long)(this.leastPrimeNumberNotLesserThanBucketSize*key) % ((long)Math.pow(2,this.wordSize)) ) / (((long)Math.pow(2,this.wordSize)) / (long)this.bucketsSize()) );
    // }
    private int indexOfBucket(KeyDataType key){
        int hashCode=key.hashCode();
        return Math.abs(hashCode) % this.bucketsSize();
    }
    private int indexInBucket(KeyDataType key,int indexOfBucket){
        int indexInBucket=0;
        for(HashMapNode node:buckets[indexOfBucket]){
            if(node.key.equals(key)){
                return indexInBucket;
            }
            indexInBucket++;
        }
        return -1;
    }
    public void put(KeyDataType key,ValueDataType value){
        int indexOfBucket=this.indexOfBucket(key);
        int indexInBucket=this.indexInBucket(key,indexOfBucket);
        if(indexInBucket==-1){
            buckets[indexOfBucket].addLast(new HashMapNode(key,value));
            this.size++;
        }
        else{
            buckets[indexOfBucket].get(indexInBucket).value=value;
        }
        this.lambda=this.size * 1.0 / this.bucketsSize();
        if(this.lambda>this.loadingFactor){
            this.rehash();
        }
    }
    private void reverseRehash(){
        LinkedList<HashMapNode>[]oldBuckets=this.buckets;
        int oldBucketsSize=this.bucketsSize();
        this.initializeBuckets(oldBucketsSize/2);
        for(int i=0;i<oldBucketsSize;i++){
            for(HashMapNode node:oldBuckets[i]){
                this.put(node.key,node.value);
            }
        }
    }
    private void rehash(){
        LinkedList<HashMapNode>[]oldBuckets=this.buckets;
        int oldBucketsSize=this.bucketsSize();
        this.initializeBuckets(2*oldBucketsSize);
        for(int i=0;i<oldBucketsSize;i++){
            for(HashMapNode node:oldBuckets[i]){
                this.put(node.key,node.value);
            }
        }
    }
    public ValueDataType remove(KeyDataType key){
        int indexOfBucket=this.indexOfBucket(key);
        int indexInBucket=this.indexInBucket(key,indexOfBucket);
        if(indexInBucket==-1){
            return null;
        }
        else{
            ValueDataType value = buckets[indexOfBucket].get(indexInBucket).value;
            buckets[indexOfBucket].remove(indexInBucket);
            this.size--;
            this.lambda=this.size * 1.0 / this.bucketsSize();
            if(this.bucketSize()>this.initialBucketsSize && this.lambda<this.minimumLoadingFactor){
                this.reverseRehash();
            }
            return value;
        }
    }
    public ValueDataType get(KeyDataType key){
        int indexOfBucket=this.indexOfBucket(key);
        int indexInBucket=this.indexInBucket(key,indexOfBucket);
        if(indexInBucket==-1){
            return null;
        }
        else{
            return buckets[indexOfBucket].get(indexInBucket).value;
        }
    }
    public boolean containsKey(KeyDataType key){
        int indexOfBucket=this.indexOfBucket(key);
        int indexInBucket=this.indexInBucket(key,indexOfBucket);
        if(indexInBucket==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<KeyDataType>keySet(){
        ArrayList<KeyDataType> keySet=new ArrayList<>();
        for(int i=0;i<this.bucketsSize();i++){
            for(HashMapNode node:buckets[i]){
                keySet.add(node.key);
            }
        }
        return keySet;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        for(int i=0;i<this.bucketsSize();i++){
            sb.append("bucketIndex: "+i+": ");
            for(HashMapNode node:buckets[i]){
                sb.append(node.key+": "+node.value+"; ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
}