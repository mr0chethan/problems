import java.util.*;
import java.io.*;
public class print_keypad_combination{
    public static Scanner scn=new Scanner(System.in);
    public static void getKPC(String ques, ArrayList<String>keyPad, String ans){
        if(ques.length()==0) System.out.println(ans); else{
            // int dig=ques.charAt(0)-'0';
            // String kPStr=keyPad.get(dig);
            // String recQues=ques.substring(1);
            for(int j=0; j<keyPad.get(ques.charAt(0)-'0').length(); j++)
            getKPC(ques.substring(1), keyPad,ans+keyPad.get(ques.charAt(0)-'0').charAt(j));
                // String recAns=ans+keyPad.get(ques.charAt(0)-'0').charAt(j);
        }
    }
    public static void main(String[] args) throws Exception{
        String ques=scn.nextLine();
        ArrayList<String>keyPad=new ArrayList<>();
        keyPad.add(".;");
        keyPad.add("abc");
        keyPad.add("def");
        keyPad.add("ghi");
        keyPad.add("jkl");
        keyPad.add("mno");
        keyPad.add("pqrs");
        keyPad.add("tu");
        keyPad.add("vwx");
        keyPad.add("yz");
        getKPC(ques,keyPad,"");
    }
}