import java.util.*;
import java.io.*;

public class recursion_arraylist{
    public static ArrayList<String> subseq(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }

        char ch=str.charAt(0);
        ArrayList<String> recAns =subseq(str.substring(1))

        ArrayList<String> myAns=new ArrayList<>();
        for (String s : recAns){
            myAns.add(ch +s);
        }
        return myAns
    }
}