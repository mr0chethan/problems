import java.util.*;

public class pattern4 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for(int row=1; row<=n; row++)
        {
            int nsp=row-1;
            int nst=n-row+1;
            int csp=0;
            while(csp<nsp)
            {
                System.out.print("  ");
                csp++;
            }
            for(int cst=1; cst<=nst; cst++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}