import java.io.*;
import java.util.*;

public class all_indices {
    public static Scanner scn=new Scanner(System.in);

    public static void input(int[]arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void display(int[]arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];

        // for (int i = 0; i < n; i++) {
        //     arr[i] = Integer.parseInt(br.readLine());
        // }
        // int x = Integer.parseInt(br.readLine());
        // int[] iarr = allIndices(arr, x, 0, 0);

        // if(iarr.length == 0){
        //     System.out.println();
        //     return;
        // }

        // for(int i = 0; i < iarr.length; i++){
        //     System.out.println(iarr[i]);
        // }
        int n=scn.nextInt();
        int[]arr=new int[n];
        input(arr);
        int x=scn.nextInt();
        int[] ans=allIndices(arr,x,0,0);
        display(ans);
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here
        if(idx==arr.length){
            int[] recAns=new int[fsf];
            return recAns;
        }
        
        if(arr[idx]!=x){
            return allIndices(arr,x,idx+1,fsf);
        }
        else{
            fsf++;
            int[]ret=allIndices(arr,x,idx+1,fsf);
            ret[fsf-1]=idx;
            return ret;
            // allIndices(arr,x,idx+1,fsf)[fsf-1]=idx;
            // return allIndices(arr,x,idx+1,fsf);
        }

        // if(idx==arr.length){
        //     int[] recAns=new int[fsf];
        //     return recAns;
        // }
        
        // if(arr[idx]!=x){
        //     return allIndices(arr,x,idx+1,fsf);
        // }
        // else{
        //     fsf++;
        //     int[]recAns=allIndices(arr,x,idx+1,fsf);
        //     recAns[fsf-1]=idx;
        //     return recAns;
        // }
    }

}