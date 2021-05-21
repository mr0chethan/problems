import java.util.*;
import java.io.*;
public class leetcode_46 {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        String str=scn.nextLine();
        String[] strA=str.substring(1,str.length()-1).split(",");
        int[]nums=new int[strA.length];
        for(int i=0; i<strA.length;i++ ) nums[i]=Integer.parseInt(strA[i]);
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            List<Integer>inBase=new ArrayList<>();
            List<List<Integer>>base=new ArrayList<>();
            base.add(inBase);
            return base;
        }
        else{
            List<List<Integer>>ans=new ArrayList<>();
            for(int i=0; i<nums.length; i++){
            int frstNum=nums[i];
            int[] excptFrstNums=new int[nums.length-1];
            for(int j=0,k=0; j<excptFrstNums.length && k<nums.length; j++,k++){
                if(k==i)k++;
                excptFrstNums[j]=nums[k];
            }
            List<List<Integer>> recAns=permute(excptFrstNums);
            for(List<Integer> list:recAns){
                list.add(0, frstNum);
                ans.add(list);
                }
            }
            return ans;
        }
    }
}