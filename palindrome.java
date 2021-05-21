import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		//write your code here
		for(int i=0; i<str.length(); i++){
		    for(int j=i+1; j<=str.length(); j++){
		        String substr=str.substring(i,j);
		        boolean palindrome=true;
		        for(int k=0; k<=substr.length()/2; k++){
		            if(substr.charAt(k)!=substr.charAt(substr.length()-1-k)){
		                palindrome=false;
		                break;
		            }
		        }
		        if(palindrome){
		            System.out.println(substr);
		        }
		        
		    }
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}