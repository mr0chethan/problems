import java.util.*;
  
  public class fibonacci{
      public static int fib(int num)
      {
        {
            if(num==1)
            return 0;
            else if(num==2)
            return 1;
            else return fib(num-1)+fib(num-2);
        }
      }
  
  public static void main(String[] args) {
      // write your code here
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      for(int i=1;i<=n;i++)
      {
        int ans = fib(i);
        System.out.println(ans);

      }
      
      
      
   }
   
  }
