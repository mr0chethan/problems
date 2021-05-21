import java.util.*;
import java.io.*;

public class ATA{
    public static Scanner scn=new Scanner(System.in);
    public static int anyBaseToDecimal(int n, int b){
        int ans=0;
        int mul=1;
    
        while(n>0){
            int rem=n%10;
            n=n/10;

            ans+=rem*mul;
            mul*=b;

        }

        return ans;
    }

    public static int decimalToAnyBase(int n, int b){
        int ans=0;
        int mul=1;
    
        while(n>0){
            int rem=n%b;
            n=n/b;

            ans+=rem*mul;
            mul*=10;

        }

        return ans;
    }

    public static void main(String[] args){
        int n=scn.nextInt();
        int b1=scn.nextInt();
        int b2=scn.nextInt();
        System.out.print(decimalToAnyBase(anyBaseToDecimal(n,b1),b2));
    }
}