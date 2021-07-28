import java.util.*;
import java.io.*;

public class interviewbit_subsets{

    public static ArrayList<ArrayList<Integer>> subsets(int[]arr, int index){
        ArrayList<ArrayList<Integer>> recAns = subsets (arr, index+1);
        for(ArrayList<Integer>subset: recAns){
            
        }
    }

    public static void main(String[]args){
        int[]arr={1,2,3};
        ArrayList<ArrayList<Integer>>subsets=new ArrayList<>();
        subsets(arr,subsets,0);

    }
}