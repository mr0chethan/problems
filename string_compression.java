import java.io.*;
import java.util.*;

public class string_compression {

	public static String compression1(String str)throws Exception{
		// write your code here
		String ans1=str.charAt(0)+"";
		for(int i=1; i<str.length(); i++){
		    if(str.charAt(i)!=ans1.charAt(ans1.length()-1)){
		        ans1+=str.charAt(i);
		    }
		}

		return ans1;
	}

	public static String compression2(String str)throws Exception{
		// write your code here
		
		






		String ans2=str.charAt(0)+"";
		
		for(int i=1; i<str.length(); i++){
		    if(str.charAt(i)!=ans2.charAt(ans2.length()-1)){
		        ans2=ans2+str.charAt(i)+"";
		    }
		    else{
		        int count=1;
		        while(i<str.length() && str.charAt(i)==ans2.charAt(ans2.length()-1)){
		            count++;
					i++;
		        }
				i--;
		        ans2+=count+"";
		    }
		}

		return ans2;
	}
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}