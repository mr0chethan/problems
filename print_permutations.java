import java.io.*;
import java.util.*;

public class print_permutations {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str=scn.nextLine();
        printPermutations(str,"");
    }

    public static void printPermutations(String str, String ans) {
        if(str.length()==0) System.out.println(ans);
        else for(int i=0; i<str.length(); i++) printPermutations(str.substring(0,i)+str.substring(i+1), ans+str.charAt(i));
    }
}