import java.util.*;
import java.io.*;

public class prime_factorisation{
public static Scanner scn=new Scanner(System.in);
public static boolean isPrime(int num){
    for(int i=2; i*i<num; i++){
        if(num%i==0){
            return false;
        }
    }
    return true;
}
public static void main(String[] args) {
  // write your code here  
  int n=scn.nextInt();
  int num=n;
  int fac=2;
  while(num!=1){
      while(/*isPrime(fac) && */ num%fac==0){
          System.out.print(fac+" ");
          num/=fac;
      }
      fac++;
  }
 }
}



// import java.util.*;
// import java.io.*;

// public class prime_factorisation{
// public static Scanner scn=new Scanner(System.in);
// public static void main(String[] args) {
//   // write your code here  
//   int n=scn.nextInt();
  
//   for(int i=2; i<n; i++){
//       boolean isPrime=true;
//       for(int j=2; j*j<=i; j++){
//           if(i%j==0){
//               isPrime=false;
//               break;
//           }
//       }
//       if(isPrime){
//           int num=n;
//           while(num%i==0){
//               System.out.print(i+" ");
//               num/=i;
//           }
//       }
//   }
//  }
// }