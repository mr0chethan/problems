import java.io.*;
import java.util.*;

public class next_greater_element_to_right{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] ques){
     int[]ans=new int[ques.length];
     Stack<Integer> stk=new Stack<>();
     stk.push(0);
     int i=0;
     while(i<ques.length){
         if(ques[i]<ques[stk.peek()]){
             stk.push(i);
             i++;
         }
         else{
             while(stk.size()>0&&ques[i]>ques[stk.peek()]){
                 ans[stk.pop()]=ques[i];
             }
             stk.push(i);
             i++;
         }
     }
     for(int j=0;j<ans.length;j++){
         if(ans[j]==0)ans[j]=-1;
     }
     
   // solve
//   int[]ans=new int[ques.length];
//   int i=ques.length-1;
//   Stack<Integer> stk=new Stack<>();
//   while(i>=0){
//       if(stk.isEmpty()){
//           ans[i]=-1;
//           stk.push(ques[i]);
//           i--;
//       }
//       else if(stk.peek()>ques[i]){
//           ans[i]=stk.peek();
//           stk.push(ques[i]);
//           i--;
//       }
//       else if(stk.peek()<ques[i]){
//           stk.pop();
//       }
//   }
  return ans;
 }

}