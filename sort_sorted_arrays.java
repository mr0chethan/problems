import java.util.*;
import java.io.*;

public class sort_sorted_arrays{
    public static void input(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=new Scanner(System.in).nextInt();
            }
        }
    }
    public static void display(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int[]sortSortedArrays(int[][]arr){
        PriorityQueue<Integer> priorityQ=new PriorityQueue<>((A,B)->{
            int rowA=A/arr[0].length, colA=A%arr[0].length, rowB=B/arr[0].length, colB=B%arr[0].length;
            return arr[rowA][colA]-arr[rowB][colB];
        });
        for(int i=0;i<arr.length;i++){
            int oneDIndex=i*arr[0].length;
            priorityQ.add(oneDIndex);
        }
        int[]sortedArray=new int[arr.length*arr[0].length];
        int i=0;
        while(priorityQ.size()>0){
            int removed=priorityQ.remove();
            int removedRow=removed/arr.length;
            int removedCol=removed%arr[0].length;
            sortedArray[i++]=arr[removedRow][removedCol];
            int nextCol=removedCol+1;
            if(nextCol<arr[0].length){
                priorityQ.add(removedRow*arr[0].length+nextCol);
            }
        }
        return sortedArray;
    }
    public static void main(String[] args){
        // System.out.println("Enter size of array of arrays");
        // int rows=new Scanner(System.in).nextInt();

        // System.out.println("Enter size of each array");
        // int cols=new Scanner(System.in).nextInt();

        // int[][]arr=new int[rows][cols];
        // input(arr);
        int[][]arr={{3,7,8,9,9},{1,1,1,2,3},{0,0,0,1,2},{-8,-5,-3,-2,10},{6,8,8,8,9}};

        int[]sortedArray=sortSortedArrays(arr);
        display(sortedArray);

    }
}