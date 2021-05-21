import java.util.*;
import java.io.*;

public class ATD{
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
    public static void main(String[] args){
        int n=scn.nextInt();
        int b=scn.nextInt();
        System.out.print(anyBaseToDecimal(n,b));
    }
}