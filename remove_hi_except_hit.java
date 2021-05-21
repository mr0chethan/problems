import java.util.*;
import java.io.*;

public class remove_hi_except_hit{
    
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("enter string:");
        String str=scn.nextLine();

        int l=str.length();

        if(l==0){
            System.out.println("");
            return;
        }
        
        String ans="";
        int i=0;

        while(i<l-2){
            if(str.charAt(i)=='h' && str.charAt(i+1)=='i' && str.charAt(i+2)!='t') i+=2;
            else{
                ans+=str.charAt(i)+"";
                i++;
            }
        }

        while(i<l){
            if(i==l-2 && str.charAt(i)=='h' && str.charAt(i+1)=='i') break;
            else{
                ans+=str.charAt(i)+"";
                i++;
            }
        }
        System.out.println(ans);
    }

}