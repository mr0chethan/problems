import java.util.*;
import java.io.*;
public class recursion_levelup {
    public static void pppppp(int a) {
        System.out.println("I am Base case: " + a);
        return;
    }

    public static void ppppp(int a) {
        System.out.println("hi: " + a);
        pppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pppp(int a) {
        System.out.println("hi: " + a);
        ppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void ppp(int a) {
        System.out.println("hi: " + a);
        pppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pp(int a) {
        System.out.println("hi: " + a);
        ppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void p(int a) {
        System.out.println("hi: " + a);
        pp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void recursionPattern(int a, int b) {
        if (a == b) {
            System.out.println("I am Base case: " + a);
            return;
        }

        System.out.println("Hi" + a);
        recursionPattern(a + 1, b);
        System.out.println("Bye" + a);
    }

    public static void printIncreasing(int a, int b) {
        if(a>b){
            return;
        }
        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b) {
        if(a>b){
            return;
        }
        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b) {
        if(a>b){
            return;
        }
        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void oddEven(int a, int b) {
        if(a>b){
            return;
        }
        if(a%2!=0){
            System.out.println(a);
        }
        oddEven(a + 1, b);
        if(a%2==0){
            System.out.println(a);
        }
    }

    public static int factorial(int n) {
        if(n==0){
            return 1;
        }
        int recAns=factorial(n-1);
        int ans=n*recAns;
        return ans;
    }

    public static int power(int a, int b) {
        if(a==0 && b==0){
            return -1;
        }
        if(a==0){
            return 0;
        }
        if(a==1 || b==0){
            return 1;
        }
        int recAns=power(a,b-1);
        int ans=a*recAns;
        return ans;
    }

    // O(logn)
    public static int powerBtr(int a, int b) {
        if(a==0 && b==0){
            return -1;
        }
        if(a==0){
            return 0;
        }
        if(a==1 || b==0){
            return 1;
        }
        int recAns=powerBtr(a,b/2);
        int ans=recAns*recAns;
        if(b%2 !=0){
            ans=a*ans;
        }
        return ans;
    }

    public static void printArray(int[] arr,int index) {//index=0
        if(index==arr.length){
            return;
        }
        System.out.println(arr[index]);
        printArray(arr,index+1);
    }

    public static void printArrayReverse(int[] arr,int index) {//index 0
        if(index==arr.length){
            return;
        }
        printArrayReverse(arr,index+1);
        System.out.println(arr[index]);
    }

    public static int maximum(int[] arr,int index) {//index 0
        if(index==arr.length-1){
            return arr[index];
        }
        int recAns=maximum(arr,++index);
        System.out.println(index);
        return Math.max(recAns,arr[index]);
    }

    public static int minimum(int[] arr,int index) {//index
        if(index==arr.length-1){
            return arr[index];
        }
        int recAns=maximum(arr,index+1);
        return Math.min(recAns,arr[index]);
    }

    public static boolean find(int[] arr, int data,int index) {//index=0
        if(index==arr.length){
            return false;
        }
        if(arr[index]==data){
            return true;
        }
        boolean recAns=find(arr,data,index+1);
        return recAns;
    }

    public static int firstIndex(int[] arr, int data,int index) {//index=0
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==data){
            return index;
        }
        int recAns=firstIndex(arr,data,index+1);
        return recAns;
    }

    public static int lastIndex(int[] arr, int data,int index) {//index=0
        if(index==arr.length){
            return -1;
        }
        int recAns=lastIndex(arr,data,index+1);
        if(recAns==-1 && arr[index]==data){
            return index;
        }
        else{
            return recAns;
        }
        
    }
    public static int[]allIndices(int[]arr,int data,int index,int countSoFar){
        if(index==arr.length){
            int[]ans=new int[countSoFar];
            return ans;
        }
        if(arr[index]==data){
            countSoFar+=1;
        }
        int[]ans=allIndices(arr,data,index+1,countSoFar);
        if(arr[index]==data){
            ans[countSoFar-1]=index;
        }
        return ans;
    }
    public static ArrayList<String>subsequences(String str,int index){
        if(index==str.length()){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String>recAns=subsequences(str,index+1);
        int recAnsSize=recAns.size();
        char ch=str.charAt(index);
        for(int i=recAnsSize/2+1;i<recAnsSize;i++){
            String ansStr=recAns.get(i);
            // if(ansStr.length()>0 && ansStr.charAt(0)==str.charAt(index+1)){
                recAns.add(""+ch+ansStr);
            // }
        }
        recAns.add(""+ch);
        System.out.println(recAns);
        return recAns;
    }

    public static int subsequences(String str,int index,ArrayList<String>ans){
        return 0;
    }

    public static ArrayList<String>keyPadCombinations(String str,String[]keyPad){
        char ch=str.charAt(0);
        int key=ch-'0';
        ArrayList<String>recAns=keyPadCombinations(str.substring(1),keyPad);
        int recAnsSize=recAns.size();
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<recAnsSize;i++){
            String recAnsStr=recAns.get(i);
            for(int j=0;j<keyPad[key].length();j++){
                char keyChar=keyPad[key].charAt(j);
                ans.add(""+keyChar+recAnsStr);
            }
        }

    }


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

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // int row=dr-sr+1;
        // int col=dc-sc+1;
        if(sr==dr && sc==dc){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        else if(dr<sr || dc<sc){
            ArrayList<String>base=new ArrayList<>();
            return base;
        }
        else{
            ArrayList<String> ans=new ArrayList<>();
            
            for(int i=1; i<=dc-sc; i++){
                ArrayList<String>recAnsH=getMazePaths(sr,sc+i,dr,dc);
                for(String str:recAnsH){
                    ans.add("h"+String.format("%d",i)+str);
                }
            }
            
            for(int i=1; i<=dr-sr; i++){
                ArrayList<String>recAnsV=getMazePaths(sr+i,sc,dr,dc);
                for(String str:recAnsV){
                    ans.add("v"+String.format("%d",i)+str);
                }
            }
            int numD=dc-sc<dr-sr ? dc-sc : dr-sr;

            for(int i=1; i<=numD; i++){
                ArrayList<String>recAnsD=getMazePaths(sr+i,sc+i,dr,dc);
                for(String str:recAnsD){
                    ans.add("d"+String.format("%d",i)+str);
                }
            }

            return ans;
        }
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

    public static void main(String[] args) {
        // recursionPattern(1, 6);
        // p(1);
        // int[]arr={9,3,2,8,2,4,8};
        // int data=8;
        // int ans=lastIndex(arr,data,0);
        // int ans=firstIndex(arr,data,0);
        // boolean ans=find(arr,9,0);
        // int ans=maximum(arr,0);
        // int ans=minimum(arr,0);
        // int ans=minimum(arr,0);
        // printArrayReverse(arr,0);
        // printArray(arr,0);
        // int ans=powerBtr(2,5);
        // int ans=power(2,5);
        // int ans=factorial(5);
        // oddEven(1,6);
        // printIncreasingDecreasing(1,6);
        // printDecreasing(1,6);
        // printIncreasing(1,6);
        // int[]ans=allIndices(arr,data,0,0);
        // for(int i=0;i<ans.length;i++){
        //     System.out.println(ans[i]);
        // }

        System.out.println(subsequences("abcd",0));
        

        //getKPC
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
        
        //getMazePaths
        int numRows=scn.nextInt();
        int numCols=scn.nextInt();
        System.out.println(getMazePaths(1,1,numRows,numCols));

        

        //pat
        int numStp=scn.nextInt();
        int maxStp=3;
        System.out.println(pat(numStp, maxStp));

        // System.out.println(ans);

    }

}