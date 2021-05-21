import java.util.*;
import java.io.*;
 
 public class merge_sorted_arrays {

// public static void printMergingTwoSortedArrays(int[] arr1, int[] arr2) {
//     // (3+5)*(arr1.length+arr2.length)
//     int i=0,j=0;
//     while((i<=arr1.length-1 || j<=arr2.length-1)&&(arr1[arr1.length-1]<=1000000000 || arr2[arr2.length-1]<=1000000000)){
//         if(arr1[i]<=arr2[j]){
//             System.out.print(arr1[i]+" ");
//             if(i==arr1.length-1){
//                 arr1[i]=1000000001;
//             }
//             if(i<arr1.length-1)
//             i++;
//         }
//         if(arr1[i]>arr2[j]){
//             System.out.print(arr2[j]+" ");
//             if(j==arr2.length-1){
//                 arr2[j]=1000000001;
//             }
//             if(j<arr2.length-1)
//             j++;
//         }
//     }
// }

public static int[] mergeTwoSortedArrays(int[]arr1,int[]arr2){
    // rajneesh sir not recommended
    int[]ans=new int[arr1.length+arr2.length];
    int i=0,j=0,k=0;
    long val1,val2;
    while(k<ans.length){
        val1=(i<arr1.length) ? arr1[i] : (long)1e18;
        val2=(j<arr1.length) ? arr2[j] : (long)1e18;
        if(val1>val2){
            ans[k++]=(int)val2;
            j++;
        }
        else{
            ans[k++]=(int)val1;
            i++;
        }
    }
    return ans;
}

// public static int[] mergeTwoSortedArrays(int[]arr1,int[]arr2){
//     // 7*min(arr1.length,arr2.length)+(5+1)*|arr1.length-arr2.length|
//     int[]ans=new int[arr1.length+arr2.length];
//     int i=0,j=0,k=0;
//     while(k<ans.length){
//         if(i==arr1.length)ans[k++]=arr2[j++];
//         else if(j==arr2.length)ans[k++]=arr1[i++];
//         else ans[k++]=arr1[i]<=arr2[j]?arr1[i++]:arr2[j++];
//     }
// }

// public static int[] mergeTwoSortedArrays(int[]arr1,int[]arr2){
//     // (2+5)*min(arr1.length,arr2.length)+(2+3)*|arr1.length-arr2.length|
//     int[]ans=new int[arr1.length+arr2.length];
//     for(int i=0,j=0,k=0;k<ans.length;k++){
//         if(i<arr1.length && j<arr2.length)ans[k]=arr1[i]<=arr2[j]?arr1[i++]:arr2[j++];
//         else ans[k]=i<arr1.length?arr1[i++]:arr2[j++];
//     }
//     return ans;
// }

// public static int[] mergeTwoSortedArrays(int[]arr1,int[]arr2){
//     // 5*min(arr1.length,arr2.length)+2*|arr1.length-arr2.length|
//     int[]ans=new int[arr1.length+arr2.length];
//     int i=0,j=0,k=0;
//     while(i<arr1.length && j<arr2.length){
//         if(arr1[i]<=arr2[j])ans[k++]=arr1[i++];
//         else ans[k++]=arr2[j++];
//     }
//     while(i<arr1.length){
//         ans[k++]=arr1[i++];
//     }
//     while(j<arr2.length){
//         ans[k++]=arr2[j++];
//     }
//     return ans;
// }
     public static void print(int[]arr){
         for(int i=0; i<arr.length; i++){
             System.out.print(arr[i]+" ");
         }
     }
     
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int[] A = new int[sc.nextInt()];
         for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
         int[] B = new int[sc.nextInt()];
         
         for (int i = 0; i < B.length; i++) {
             B[i] = sc.nextInt();
         }
        //  printMergingTwoSortedArrays(A, B);

        
        int[]ans=mergeTwoSortedArrays(A,B);
        print(ans);
     }
     
 }