import java.io.*;
import java.util.*;

public class toggle {

	public static String toggleCase(String str){
		//write your code here
        StringBuilder sb1=new StringBuilder();
        sb1.append(str);

        for(int i=0; i<str.length(); i++){
            if(96<sb1.charAt(i))
            sb1.setCharAt(i, (char)(sb1.charAt(i)-('a'-'A')));
            else
            sb1.setCharAt(i, (char)(sb1.charAt(i)+('a'-'A')));
        }







		return sb1.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}