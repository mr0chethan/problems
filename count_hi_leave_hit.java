import java.io.*;
import java.util.*;

public class count_hi_leave_hit{

    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("enter the string:");
        String str=scn.nextLine();

        int l=str.length();

        int ans=0;

        if(l==0 || l==1){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<l-1; i++){
            // if (str.substring(i,i+2).equals("hi")){
            if (str.charAt(i)=='h' && str.charAt(i+1)=='i'){
                ans++;
                if(i+2<l){
                    if(str.charAt(i+2)=='t'){
                        ans--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
