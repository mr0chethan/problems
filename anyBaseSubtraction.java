import java.util.*;
import java.io.*;
  
    public class anyBaseSubtraction{
    Scanner scn = new Scanner(System.in);
  
        public static void main(String[] args) {
      
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
  
        int d = getDifference(b, n1, n2);
        System.out.println(d);
   }
    
    public static int getDifference(int b, int n1, int n2){
       // write your code here
       int borrow=0;
       int ans=0;
       int mul=1;
       while(n2!=0){
           int diff=(n2%10-borrow-n1%10<0 ? n2%10+b-borrow-n1%10 : n2%10-borrow-n1%10);
           borrow=(n2%10-borrow-n1%10<0 ? 1 : 0);
           ans+=diff*mul;
           mul*=10;
           n1/=10;
           n2/=10;
       }
       return ans;
   }
  
  }