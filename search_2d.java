import java.util.*;
import java.io.*;

public class search_2d{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[][]a){
        int n=a.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j]=scn.nextInt();
            }
        }
    }
    
    
    public static void main(String args[]){
        int n=scn.nextInt();
        int[][]a=new int[n][n];
        input(a);
        int x=scn.nextInt();

        int sr=0; int er=n-1; int sc=0; int ec=n-1;

        int row=-1;
        int col=-1;

        while(true){
            if(sr==er && sc==ec && a[sr][sc]==x){
                System.out.println(sr);
                System.out.println(sc);
                break;
            }
            if(x<a[sr][sc] || a[er][ec]<x){
                System.out.println("Not Found");
                break;
            }

            if(a[er][sc]<x)
            sc++;

            if(a[sr][ec]<x)
            sr++;

            if(x<a[sr][ec])
            ec--;

            if(x<a[er][sc])
            er--;

        }

        







        
        
        
        


        
        
    }

}