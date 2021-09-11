import java.io.*;
import java.util.*;

public class leetcode_91 {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str=scn.nextLine();
        // printEncodings(str,0);
        int[]dp = new int[str.length()+1];
        Arrays.fill(dp,-1);
        int count = numDecodingsMemo(str,0,dp,false);
        System.out.println(count);
   }

   private static int numDecodingsMemo(String s,int index, int[]dp, boolean sIndexIsStar){
    //    System.out.println("called: string: "+s+" index: "+index);
    if(index==dp.length-1){
        if(sIndexIsStar){
            return 1;
        }
        return dp[index]=1;
    }
    if(dp[index]!=-1 && !sIndexIsStar){
        return dp[index];
    }
    int firstDigit = s.charAt(index)-'0';
    if(firstDigit == 0){
        return dp[index]=0;
    }
    if(firstDigit=='*'-'0'){
        int count = 0;
        String left = s.substring(0,index);
        String right = s.substring(index+1);
        for(int d=1;d<=9;d++){
            count += numDecodingsMemo(left + d + right, index, dp, true);
        }
        return dp[index] = count;
    }
    int count = numDecodingsMemo(s,index+1,dp,false);
    if(index<dp.length-2){
        int secondDigit = s.charAt(index+1)-'0';
        if(secondDigit=='*'-'0'){
            for(secondDigit = 1; secondDigit <=9; secondDigit++){
                int num = firstDigit * 10 + secondDigit;
                count += num<=26 ? numDecodingsMemo(s,index+2,dp,true) : 0;
            }
        }
        else{
            int num = firstDigit * 10 + secondDigit;
            count += num<=26 ? numDecodingsMemo(s,index+2,dp,false) : 0;
        }
    }
    if(sIndexIsStar){
        return count;
    }
    return dp[index]=count;
}

    public static void printEncodings(String str, int cnt) {
        if(str.length()==0) System.out.println(cnt);
        else{
            int frst=Integer.parseInt(str.substring(0,1));
            if(frst==0) return;
            char dcdFrst=(char)(frst-1+'a');
            printEncodings(str.substring(1),++cnt);
            if(2<=str.length()){
                int frstTwo=Integer.parseInt(str.substring(0,2));
                if(frstTwo<=26){
                    char dcdFrstTwo=(char)(frstTwo-1+'a');
                    printEncodings(str.substring(2),++cnt);
                }
            }
        }
    }
//     public static void printEncodings(String str, int cnt) {
//         if(str.length()==0) System.out.println(cnt);
//         else{
//             int frst=Integer.parseInt(str.substring(0,1));
//             if(frst==0) return;
//             char dcdFrst=(char)(frst-1+'a');
//             printEncodings(str.substring(1),++cnt);
//             if(2<=str.length()){
//                 int frstTwo=Integer.parseInt(str.substring(0,2));
//                 if(frstTwo<=26){
//                     char dcdFrstTwo=(char)(frstTwo-1+'a');
//                     printEncodings(str.substring(2),++cnt);
//                 }
//             }
//         }
//     }
}