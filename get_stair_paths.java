import java.io.*;
import java.util.*;

public class get_stair_paths {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int numStp=scn.nextInt();
        int maxStp=3;
        System.out.println(pat(numStp, maxStp));

    }

    public static ArrayList<String> pat(int numStp, int maxStp) {
        if(numStp==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        //below base case is not needed if difMax is used instead of maxStp
        else if(numStp<0){
            ArrayList<String>base=new ArrayList<>();
            return base;
        }
        else{
            // int difMax=numStp>maxStp ? maxStp : numStp;
            ArrayList<String>ans=new ArrayList<>();
            //in next line difMax can be used in place of maxStp in that case base case for numStp<0 is not needed
            for(int i=1; i<=maxStp; i++){
                ArrayList<String>recAns=pat(numStp-i,maxStp);
                for(String s:recAns){
                    ans.add(s+" "+String.format("%d",i));
                }
            }
            return ans;
        }
    }
}