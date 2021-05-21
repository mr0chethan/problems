import java.util.*;
    
    public class gcdlcm{
    
    public static void main(String[] args) {
      // write your code here
      Scanner scn=new Scanner(System.in);
      int num1=scn.nextInt();
      int num2=scn.nextInt();
      int max=num1;
      int min=num2;
      if(max<min)
      {
          int temp= max;
          max=min;
          min=temp;
      }
      while(min!=0)
      {
          max=max%min;
          if(max<min)
          {
              int temp= max;
              max=min;
              min=temp;
          }
      }
      int a=max;
      int b=(num1*num2)/a;
      System.out.println(a);
      System.out.println(b);
      
      
     }
    }