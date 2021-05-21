import java.util.*;
import java.io.*;

public class remove_hi{
    
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

        while(i<l-1){
            if(str.charAt(i)=='h' && str.charAt(i+1)=='i') i+=2;
            else{
                ans+=str.charAt(i)+"";
                i++;
            }
        }

        if(!(str.charAt(l-2)=='h' && str.charAt(l-1)=='i')){
            ans=ans+str.charAt(l-1)+"";
        }
        System.out.println(ans);
    }

}