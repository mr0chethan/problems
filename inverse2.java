import java.util.*;
public class inverse2{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int d=0;
        
        int t=n;
        
        while(t>0)
        {
            d++;
            
            t=t/10;
            
        }
        int temp=n;
        int i=1;
        int ans=0;
        while(temp>0)
        {
            int ext=temp%10;
            ans+=i*Math.pow(10,ext-1);
            i++;
            temp=temp/10;
        }
        System.out.println(ans);
    }
}

        