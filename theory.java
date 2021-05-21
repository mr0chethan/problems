import java.util.*;
import java.io.*;

public class theory{
    public Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception{

        // char ch='a'+1; //b
        // char ch='a'+'1'; //?
        // char ch='a'+"1"; //error: incompatible types: String cannot be converted to char
        // char ch='a'+'b'; //?
        // char ch='a'+"b"; //error: incompatible types: String cannot be converted to char
        // char ch="a"+"b"; //error: incompatible types: String cannot be converted to char
        // char ch='a+1'; //error: unclosed character literal //error: not a statement
        // char ch='a+b'; //error: unclosed character literal //error: not a statement
        // System.out.println(ch);

        // String str='a'; //error: incompatible types: char cannot be converted to String
        // String str='a'+1; //error: incompatible types: int cannot be converted to String
        // String str='a'+'1'; //error: incompatible types: int cannot be converted to String
        // String str='a'+"1"; //a1
        // String str='a'+'b'; //error: incompatible types: int cannot be converted to String
        // String str='a'+"b"; //ab
        // String str="a"+1; //a1
        // String str="a"+"b"; //ab
        // String str='a+1'; //error: unclosed character literal //error: not a statement
        // String str='a+b'; //error: unclosed character literal //error: not a statement
        // String str='a'+1+2; //error: incompatible types: int cannot be converted to String
        // String str=1+2+'a'; //error: incompatible types: int cannot be converted to String
        // String str="a"+1+2; //a12
        // String str=1+2+"a"; //3a
        // System.out.println(str);
        
        // int n='a'; //97
        // int n='a'+1; //98
        // int n='a'+'1'; //146
        // int n='a'+"1"; //error: incompatible types: String cannot be converted to int
        // int n='a'+'b'; //195
        // int n='a'+"b"; //error: incompatible types: String cannot be converted to int
        // int n="a"+1; //error: incompatible types: String cannot be converted to int
        // int n="a"+"b"; //error: incompatible types: String cannot be converted to int
        // int n='a+1'; //error: unclosed character literal //error: not a statement
        // int n='a+b'; //error: unclosed character literal //error: not a statement
        // int n='a'+1+2; //100
        // int n=1+2+'a'; //100
        // int n="a"+1+2; //error: incompatible types: String cannot be converted to int
        // int n=1+2+"a"; //error: incompatible types: String cannot be converted to int
        // System.out.println(n);

        // String s1="hello";
        // String s2="hello";
        // String s3=new String("hello");
        // System.out.println(s1);//hello NOT "hello"
        // System.out.println(s2);//hello NOT "hello"
        // System.out.println(s3);//hello NOT "hello"
        // System.out.println(s1==s2);//true
        // System.out.println(s2==s3);//false
        // System.out.println(s1.equals(s2));//true
        // System.out.println(s1.equals(s3));//true

        // int [] arr={1,2,3};
        // int [] arr2={1,2,3};
        // int [] arr3=new int[3];
        // arr3[0]=1;
        // arr3[1]=2;
        // arr3[2]=3;
        // arr[1]=5;

        // arr3={1,2,3}; //error: illegal start of expression // error: not a statement

        // System.out.println(arr); //[I@15db9742
        // System.out.println(arr2); //[I@15db9742
        // System.out.println(arr3); //error: class, interface, or enum expected //error: <identifier> expected //[I@7852e922

        // System.out.println(arr[1]);//5
        // System.out.println(arr2[1]);//2
        // System.out.println(arr3[1]);//2

        // arr3[2]=7;

        // System.out.println(arr[2]);//3
        // System.out.println(arr2[2]);//3
        // System.out.println(arr3[2]);//7

        // int [] arr={1,2,3};
        // int [] arr2=arr;
        // int [] arr3=new int[3];

        // System.out.println(arr);//[I@15db9742
        // System.out.println(arr2);//[I@15db9742
        // System.out.println(arr3);//[I@6d06d69c
        
        // arr[1]=5;

        // arr3[0]=1;
        // arr3[1]=5;
        // arr3[2]=3;

        // System.out.println(arr[1]);//5
        // System.out.println(arr2[1]);//5
        // System.out.println(arr3[1]);//0

        // System.out.println(arr==arr2);//true
        // System.out.println(arr2==arr3);//false

        // String s1="hello";
        // String s2="hello";
        // s1="bye";
        // System.out.println(s1);//bye
        // System.out.println(s2);//hello
        // System.out.println(s1==s2);//fa;se

        // String s1="hello";
        // String s2=s1;
        // System.out.println(s1==s2);//true

        // s1="bye";

        // System.out.println(s1);//bye
        // System.out.println(s2);//hello
        // System.out.println(s1==s2);//false

        // String str="hello";
        // System.out.println(str[0]); //error: array required, but String found
        // System.out.println(str.charAt(0));//h
        // str.charAt(0)='j';//error: unexpected type //required: variable found: value
        // System.out.println(str.charAt(0)=='h');//true

        // StringBuilder sb=new StringBuilder("Hello");
        // System.out.println(sb);
        // System.out.println(sb.charAt(2));//l

        // sb.setCharAt(0, 'd');
        // System.out.println(sb);//dello

        // String str=new String("bye");
        // str.setCharAt(0,'h');//
        // System.out.println(str);//error: cannot find symbol

        // sb.insert(1,'b');
        // System.out.println(sb);//Hbello
        // sb.insert(1,"ch");
        // System.out.println(sb);//Hchbello

        // sb.setCharAt(2,"po");
        // System.out.println(sb);// error: incompatible types: String cannot be converted to char
        // sb.insert(2,'po');
        // System.out.println(sb);//error: unclosed character literal//error: ';' expected
        // sb.setCharAt(2,'po');
        // System.out.println(sb);////error: unclosed character literal//error: ';' expected

        // sb.deleteCharAt(2);
        // System.out.println(sb);//Hcbello

        // sb.append('g');
        // System.out.println(sb);//Hcbellog

        // long start=System.currentTimeMillis();
        // String str=new String("");
        // int n=100000;
        // for(int i=0; i<n; i++){
        //     str+=i;
        // }
        // System.out.println(str);
        // long end=System.currentTimeMillis();
        // System.out.println("time taken");
        // System.out.println(end-start);

        // long start=System.currentTimeMillis();
        // StringBuilder sb=new StringBuilder("");
        // int n=100000;
        // for(int i=0; i<n; i++){
        //     sb.append(i);
        // }
        // System.out.println(sb);
        // long end=System.currentTimeMillis();
        // System.out.println("time taken");
        // System.out.println(end-start);

        // StringBuilder sb=new StringBuilder("abc");
        // sb=sb+"def";
        // System.out.println(sb);//error: incompatible types: String cannot be converted to StringBuilder

        // int[] arr={1,2,3};
        // System.out.println(arr[-1]);//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1

        // int[]arr;//error: variable arr might not have been initialized
        // System.out.println(arr);
        // int[]arr=new int[];//error: array dimension missing

        // int arr[]={1,2,3};
        // arr.delete(2);//delete, pop, remove, append, insert, push, add //error: cannot find symbol
        // remove arr[2];//error: illegal start of expression
        // System.out.println(arr);
        // System.out.println(arr(0));//error: cannot find symbol method add(int)
        // arr.add(4);////error: cannot find symbol method add(int)

        // ArrayList<Integer> al=new ArrayList<>();

        // System.out.println(al);//[]
        // System.out.println(al.size());//0

        ArrayList<Integer> al=new ArrayList<>();

        al.add(1);
        al.add(2);
        System.out.println(al);// [1, 2]
        System.out.println(al.size());//2
        // System.out.println(al(0));//al[0] error: array required, but ArrayList<Integer> found

        // al.add(1,1000);
        // System.out.println(al);//[1, 1000, 2]
        // System.out.println(al.get(1));//2
        al.set(1,7);
        System.out.println(al);//[1,7]
        // al.add(1,5,6,7);
        // System.out.println(al);// method Collection.add(Integer) is not applicable (actual and formal argument lists differ in length)
        al.remove(0);
        System.out.println(al);//[7]

        ArrayList<String> al2=new ArrayList<>();
        al2.add("hello");
        al2.add("bello");
        System.out.println(al2);//[hello, bello] //NOT ["hello", "bello"]

        for(String s:al2){
            System.out.println(s);//hello bello NOT "hello" "bello"
        }



        
        











    }
}