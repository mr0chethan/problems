import java.util.*;

public class inverse{

public static void main(String[] args) {
  // write your code here 
  Scanner scn=new Scanner(System.in);
  int n=scn.nextInt();
  int d=0;
  int t=n;
  while(t>0)
  {
      d++;
      t=t/10;
  }
  
  
  for(int s=d; s>=1; s--)
  {
    
    int div=1;
      for(int i=1; i<=d; i++)
      {
          div=div*10;
          int x=div/10;
          
          if(((n%div)/x)==s)
          {
            System.out.print(i);

          }
          
      }
  }
  
 }
}