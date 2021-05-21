import java.io.*;
import java.util.*;

public class print_subsequence {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args)  {
        String ques=scn.nextLine();
        gss(ques,"");
    }

    public static void gss(String ques, String ans)  {
        if(ques.length()==0) System.out.println(ans); else{
            // char ch=ques.charAt(0);
            // String recQues=ques.substring(1);
            gss(ques.substring(1), ans+ques.charAt(0));
            gss(ques.substring(1), ans+"");
        }
    }
}