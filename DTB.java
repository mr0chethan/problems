import java.util.*;
import java.io.*;

public class DTB{
    public static Scanner scn=new Scanner(System.in);
    public static int decimalToBinary(int n){
        int ans=0;
        int mul=1;
    
        while(n>0){
            int rem=n%2;
            n=n/2;

            ans+=rem*mul;
            mul*=10;

        }

        return ans;
    }
    public static void main(String[] args){
        int n=scn.nextInt();
        System.out.print(decimalToBinary(n));
    }
}