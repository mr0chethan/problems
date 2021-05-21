import java.util.*;
    
    public class printdigits{
    
    public static void main(String[] args) {
      // write your code here 
      Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int d=1;
    int num=n;
    while(num/10>0)
    {
        d++;
        num=num/10;
        
    }
    int v=1;
    int count=1;
    while(count<d)
    {
        v=v*10;
        count++;
    }
    while(v>0)
    {
        int q =n/v;
        System.out.println(q);
        n=n%v;
        v=v/10;
    }
     }
    }