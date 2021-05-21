import java.io.*;
import java.util.*;

public class get_subsequence {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str=scn.nextLine();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String>empty=new ArrayList<>();
            empty.add("");
            return empty;
        }
        else{
            char ch=str.charAt(0);
            ArrayList<String> recAns=gss(str.substring(1));
            int recAnsSiz=recAns.size();
            for(int i=0; i<recAnsSiz; i++){
                recAns.add(ch+recAns.get(i));
            }
            return recAns;
            // ArrayList<String> ans=new ArrayList<>();
            // for(String s:recAns){
            //     ans.add(s);
            //     ans.add(ch+s+"");
            // }
            // return ans;

        }
    }
}