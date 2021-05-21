import java.io.*;
import java.util.*;

public class rotate_array{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k){
    // write your code here
    int rotateNumber=0;
    if(k%a.length!=0){
        if(k%a.length>0)
        rotateNumber=k%a.length;
        else if(k%a.length<0)
        rotateNumber=a.length+k%a.length;
        for(int j=1; j<=rotateNumber; j++){
            int temp=a[a.length-1];
            for(int i=a.length-1; i>0; i--){
                a[i]=a[i-1];
            }
            a[0]=temp;
        }
    }
    
    
    
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
    
 }

}