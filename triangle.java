import java.io.*;
import java.util.*;
public class triangle {
    public static Scanner scn= new Scanner(System.in);
    public static void pattern1(){
        int n=scn.nextInt();
        for(int row=1; row<=n; row++){
            int nst=row;
            for(int cst=1; cst<=nst; cst++){
                System.out.print("*");
            }
            System.out.println("");
            
        }
    }
    public static void main(String[] args) {
        pattern1();
    

 }
 }
