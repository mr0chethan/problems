import java.util.*;
  
  public class bulb{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    for(int b=1; b<=n; b++)
    {
        Boolean switch=false;
        for(int f=1; f<=n; f++)
        {
            if(b%f==0)
            switch=!switch;
        }
        if(switch)
        System.out.println(b);
    }
   }
  }