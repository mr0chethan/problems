import java.util.*;
   
   public class rotate{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn=new Scanner(System.in);
     int n =scn.nextInt();
     int k=scn.nextInt();
     int t=n;
     int d=0;
     while(t>0)
     {
        d++;
        t=t/10;
     }
     int x;
     if(k>=0)
     x=k%d;
     else
     x=d+k%d;
     
     int r=n;
     
     for(int i=1; i<=x; i++)
     {
         int add =r/10;
         int mul=(r%10)*(int)Math.pow(10,d-1);
         r=add+mul;
     }
     System.out.println(r);
     
    }
   }