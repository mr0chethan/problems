import java.io.*;
import java.util.*;

public class count_hi{
    public static Scanner scn=new Scanner(System.in);

    public static int countHi(String str) {
        int n=str.length();
        if(n==0 || n==1) return 0;
        int i=0, ans =0;
        while(i<n){
          if(str.charAt(i)!='h') i++;
          while(i<n && str.charAt(i) == 'h'){
            i++;
            if(i<n && str.charAt(i)=='i'){
              ans++;
              i++;
            }
            else if (i<n) i++;
          }
        }
        return ans;
      }
    public static void main(String[] args){
        System.out.println("enter the string:");
        String str=scn.nextLine();
        System.out.println(countHi(str));
    }
    

      

}
