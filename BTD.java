import java.util.*;
import java.io.*;

public class BTD{
    public static Scanner scn=new Scanner(System.in);
    public static int binaryToDecimal(int n){
        int ans=0;
        int mul=1;
    
        while(n>0){
            int rem=n%10;
            n=n/10;

            ans+=rem*mul;
            mul*=2;

        }

        return ans;
    }
    public static void main(String[] args){
        int n=scn.nextInt();
        System.out.print(binaryToDecimal(n));
    }
}