import java.io.*;
import java.util.*;

public class merge_overlapping_intervals {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        Queue<int[]>q=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        int[]removed=q.remove();
        ArrayList<int []>al=new ArrayList<>();
        while(!q.isEmpty()){
            int[] peeked=q.peek();
            if(removed[1]>=peeked[0]){
                q.remove();
                removed[1]=Math.max(removed[1],peeked[1]);
            }
            else{
                al.add(removed);
                removed=q.remove();
            }
        }
        al.add(removed);
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i)[0]+" "+al.get(i)[1]);
        }
    }

}