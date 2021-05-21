import java.util.*;

public class nstcst{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        for(int nst=1; nst<=n;nst++)
        {
            for(int cst=1; cst<=nst; cst++)
            {
                System.out.print("*\t");
            }
            System.out.print("\n");
        }

    }
}