import java.io.*;
import java.util.*;

public class string_difference_consecutive {

	public static String solution(String str){
		// write your code here
        String ans=str.charAt(0)+"";
        for(int i=0; i<str.length()-1; i++){
            int diff=str.charAt(i+1)-str.charAt(i);
            ans+=""+diff;
            ans+=""+str.charAt(i+1);
        }
        return ans;

		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}