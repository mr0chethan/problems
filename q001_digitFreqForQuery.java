import java.util.*;

public class q001_digitFreqForQuery{
    public static Scanner scn= new Scanner(System.in);
    
    public static void  digitFreq(long n, int[] query){
        for (int q:query){
            int [] freq=new int[10];

            while(n!=0){
                int d =(int)(n%10);
                n/=10;
                freq[d]++;
            }

            for(int i:query){
                System.out.println(freq[i]);
            }
        }
    }
    public static void main(String[] args){
        long n=scn.nextLong();
        int[] query =new int[scn.nextInt()];
        for(int i=0; i<query.length; i++){
            query[i]=scn.nextInt();
        }
        digitFreq(n, query);
    }
}