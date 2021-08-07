import java.util.*;
public class bit{

    public static int offKthBit( int num, int k){
        int mask = ~(1 << k);
        return num & mask;
    }
    public static int onKthBit( int num, int k){
        int mask = 1 << k;
        return num | mask;
    }
    public static int checkKthBit( int num, int k){
        int mask = 1 << k;
        if( (num & mask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int toggleKthBit( int num, int k){
        int mask = 1 << k;
        return num ^ mask;
    }

    public static int countBits( int num){
        int count =0;
        for( int i =0; i < 32; i++){
            if( checkKthBit( num, i) == 1){
                count ++;
            }
        }
        return count;
    }
    public static int countBits2( int num){
        int count = 0;
        while( num != 0 ){
            if((num & 1) == 1){
                count++;
            }
            num >>= 1;
        }
        return count;
    }
    public static int countBits3( int num){
        int count =0;
        while(num != 0){
            num = num & num-1;
            count++;
        }
        return count;
    }

    public static void main(String[]myArgs){
        // System.out.println( offKthBit(5, 2));
        // System.out.println( onKthBit(5, 2));

        // System.out.println( checkKthBit(5, 2));
        // System.out.println( countBits( 20));
        // System.out.println( countBits2( 20));
        // System.out.println( countBits3( 20));
        // System.out.println( toggleKthBit(5,0));
        

        Scanner scn=new Scanner (System.in);
        int x=scn.nextInt();
        System.out.println(x+3);
        
    }
}