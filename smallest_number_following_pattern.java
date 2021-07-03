import java.io.*;
import java.util.*;

public class smallest_number_following_pattern{
    
    static String smallestNumberFollowingPattern(String string){
        Stack<Integer>stack=new Stack<>();
        String answer="";
        stack.push(1);
        for(int i=0;i<string.length();i++){
            char ch=string.charAt(i);
            int v=stack.peek();
            if(ch=='i'){
                while(!stack.isEmpty()){
                    answer+=""+stack.pop();
                }
            }
            stack.push(v+1);
        }
        while(!stack.isEmpty()){
            answer+=""+stack.pop();
        }
        return answer;
    }
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    System.out.println(smallestNumberFollowingPattern(str));

    // code
    
 }
}