import java.util.*;

public class pattern2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        for(int row=1; row<=n; row++)
        {
            int nsp=n-row;
            int nst=row;
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print(" ");
            }
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*");
            }
            System.out.println();
            
        }

    }
}