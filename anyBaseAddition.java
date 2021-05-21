import java.util.*;
  
  public class anyBaseAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int ans=0;
       int mul=1;
       int carry=0;
       while(n1>0 || n2>0){
           int remn1=n1%10;
           int remn2=n2%10;
           n1=n1/10;
           n2=n2/10;
           ans=ans+((remn1+remn2+carry)%b)*mul;
           carry=(remn1+remn2+carry>=b ? 1 : 0);
           mul*=10;
       }
       return ans+carry*mul;
   }
  }