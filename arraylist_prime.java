import java.io.*;
import java.util.*;

public class arraylist_prime {

	public static void solution(ArrayList<Integer> al){
		// write your code here
        // int n=al.size();
        ArrayList<Integer> a2=new ArrayList<>();

        for(int i=0; i<n; i++){
            a2.add(al.get(i));
        }

        for(int i=n-1; i>=0; i--){
            al.remove(i);
        }

        for(int i=0; i<n; i++){
            if(!isPrime(a2.get(i))){
                al.add(a2.get(i));
            }

        }



		
	}

    public static boolean isPrime(int num){
        boolean boolIsPrime=true;
        for( int i=2; i*i<num; i++){
            if(num%i==0){
                boolIsPrime=false;
                break;
            }
        }
        return boolIsPrime;
    }


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}