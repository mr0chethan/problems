import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class remove_primes {

    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

	public static void solution(ArrayList<Integer> al){
		// write your code here
        int i=0;
        while(i<al.size()){
            if(isPrime(al.get(i))){
                // System.out.println("removing: "+al.get(i));
                al.remove(i);
            }
            else
            i++;

        }
	}


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
        // System.out.println(isPrime(4));
		solution(al);
		System.out.println(al);
	}

}