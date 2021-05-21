import java.util.*;
  
  public class prime{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      
       // write ur code here
       int t=scn.nextInt();
       
       for(int j=1; j<=t; j++)
       {
       int n=scn.nextInt();
       boolean val=true;
       

       for(int i=2;i*i<=n;i++)
       {
           if(n%i==0)
           {
           val=false;
           break;
           }
       
       }
       if(val)
       {
           System.out.println("prime");
       }
       else
       {
           System.out.println("not prime");

       }

       }
       
  
   }
  }