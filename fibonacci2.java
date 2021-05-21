import java.util.*;
public class fibonacci2{
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int v1;
        int v2;
        int v3;
        if(n==1)
        {
            v1=0;
            System.out.println(v1);
        }
        else if(n==2)
        {
            v1=0;
            v2=1;
            System.out.println(v1);
            System.out.println(v2);

        }
        else
        {
            v1=0;
            v2=1;
            System.out.println(v1);
            System.out.println(v2);
            for(int i=3; i<=n; i++)
            {
                v3=v2+v1;
                v1=v2;
                v2=v3;
                
                System.out.println(v3);
            }

        }
    }

}

