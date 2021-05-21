import java.util.*;
import java.io.*;

public class DTA{
    public static Scanner scn=new Scanner(System.in);
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
        int b=scn.nextInt();
        System.out.print(decimalToAnyBase(n,b));
    }
}