import java.io.*;
import java.util.*;

public class celebrity {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer>stk=new Stack<>();
        for(int i=0;i<arr.length;i++){
            stk.push(i);
        }
        while(stk.size()!=1){
            int a=stk.pop();
            int b=stk.pop();
            if(arr[a][b]==0){
                stk.push(a);
            }
            else{
                stk.push(b);
            }
        }
        int i=stk.peek();
        
        
        
        // int i=0, j=arr.length-1;
        // while(i!=j){
        //     if(arr[i][j]==0)j--;
        //     else i++;
        // }
        boolean ans=true;
        for(int k=0;k<arr.length;k++){
            if(arr[i][k]==1){
                ans=false;
                break;
            }
            if(k!=i && arr[k][i]==0){
                ans=false;
                break;
            }
        }
        if(ans){
            System.out.println(i);
        }
        else{
            System.out.println("none");
        }
        
    }

}