import java.util.*;
import java.io.*;
public class keypad_combination{
    public static Scanner scn=new Scanner(System.in);
    public static ArrayList<String> getKPC(String str, ArrayList<String>keyPad){
        if(str.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        else{
            int dig=str.charAt(0)-'0';
            String kPStr=keyPad.get(dig);
            ArrayList<String>recAns=getKPC(str.substring(1), keyPad);
            ArrayList<String>ans=new ArrayList<>();
            for(int j=0; j<kPStr.length(); j++){
                for(String s:recAns){
                    ans.add(""+kPStr.charAt(j)+s);
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) throws Exception{
        String str=scn.nextLine();
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
        System.out.println(getKPC(str,keyPad));
    }
}