import java.io.*;
import java.util.*;

public class print_stair_paths {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int numStp=scn.nextInt();
        int maxStp=3;
        pat(numStp, maxStp, "");
    }

    public static void pat(int numStp, int maxStp, String ans) {
        if(numStp==0) System.out.println(ans);
        else if(numStp<0) return; else
        for(int i=1; i<=maxStp; i++) pat(numStp-i, maxStp, ans+String.format("%d",i));
    }
}
