import java.util.*;
import java.io.*;

public class recursion{
    public static void ppppppp(int a , int b){
        return;
    }
    public static void pppppp(int a , int b){
        System.out.println(a);
        ppppppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void ppppp(int a , int b){
        System.out.println(a);
        pppppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void pppp(int a , int b){
        System.out.println(a);
        ppppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void ppp(int a , int b){
        System.out.println(a);
        pppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void pp(int a , int b){
        System.out.println(a);
        ppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void p(int a, int b){
        System.out.println(a);
        pp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void printIncreasing(int a, int b){
        if(a>b)
        return;
        System.out.println(a);
        printIncreasing(a+1,b);
        System.out.println("hi"+a);
    }

    public static void main(String[] args){
        int a=2;
        int b=7;
        p(a,b);
        // printIncreasing(a,b);
    }
}