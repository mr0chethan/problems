import java.io.*;
import java.util.*;

public class leetcode_91 {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str=scn.nextLine();
        printEncodings(str,0);
   }

    public static void printEncodings(String str, int cnt) {
        if(str.length()==0) System.out.println(cnt);
        else{
            int frst=Integer.parseInt(str.substring(0,1));
            if(frst==0) return;
            char dcdFrst=(char)(frst-1+'a');
            printEncodings(str.substring(1),++cnt);
            if(2<=str.length()){
                int frstTwo=Integer.parseInt(str.substring(0,2));
                if(frstTwo<=26){
                    char dcdFrstTwo=(char)(frstTwo-1+'a');
                    printEncodings(str.substring(2),++cnt);
                }
            }
        }
    }
    public static void printEncodings(String str, int cnt) {
        if(str.length()==0) System.out.println(cnt);
        else{
            int frst=Integer.parseInt(str.substring(0,1));
            if(frst==0) return;
            char dcdFrst=(char)(frst-1+'a');
            printEncodings(str.substring(1),++cnt);
            if(2<=str.length()){
                int frstTwo=Integer.parseInt(str.substring(0,2));
                if(frstTwo<=26){
                    char dcdFrstTwo=(char)(frstTwo-1+'a');
                    printEncodings(str.substring(2),++cnt);
                }
            }
        }
    }
}