import java.io.*;
import java.util.*;

public class print_encodings {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str=scn.nextLine();
        printEncodings(str,"");
   }

    public static void printEncodings(String str, String ans) {
        if(str.length()==0) System.out.println(ans);
        else{
            int frst=Integer.parseInt(str.substring(0,1));
            if(frst==0) return;
            char dcdFrst=(char)(frst-1+'a');
            printEncodings(str.substring(1),ans+dcdFrst);
            if(2<=str.length()){
                int frstTwo=Integer.parseInt(str.substring(0,2));
                if(frstTwo<=26){
                    char dcdFrstTwo=(char)(frstTwo-1+'a');
                    printEncodings(str.substring(2),ans+dcdFrstTwo);
                }
            }
        }
    }
}