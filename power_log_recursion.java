import java.io.*;
import java.util.*;

public class power_log_recursion {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        if(x==0 && n==0){
            System.out.println("Undefined");
            return;
        }
        
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        
        if(n%2==0){
            return power(x,n/2)*power(x,n/2);
        }
        
        if(n%2==1){
            return x*power(x,n/2)*power(x,n/2);
        }
        return 1;
        
    }

}
