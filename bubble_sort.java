import java.util.Scanner;
 
 public class bubble_sort {
 
 	 public static void bubble(int arr[], int n) {
          long time1=System.nanoTime();
 	 //Write your code here.
      for(int i=arr.length-1; 0<i; i--){
        int countSwap=0;
        for(int j=0; j<i; j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                countSwap++;
            }

        }
        if(countSwap==0) break;
      }
      long time2=System.nanoTime();
      System.out.println(time2-time1+"ns");
 	}

 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 int n = s.nextInt();
 	 	 int[] ar = new int[n];
 	 	 for (int i = 0; i < ar.length; i++) {
 	 	 	 ar[i] = s.nextInt();
 	 	 }
 
 	 	 bubble(ar, n);
 	 	 for (int val : ar)
 	 	 	 System.out.print(val + " ");
 	 }
 
 }