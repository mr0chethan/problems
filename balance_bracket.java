import java.io.*;
import java.util.*;

public class balance_bracket {
    public static Scanner scn=new Scanner(System.in);

    public static boolean balanceBracket(String input){
        Stack<Character> stk=new Stack<>();
        boolean ans=true;
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='('||ch=='['||ch=='{'){
                stk.push(ch);
            }
            else if(ch==')'){
                if(stk.peek()=='(')stk.pop();
                else {ans=false;break;}
            }
            else if(ch=='}'){
                if(stk.peek()=='{')stk.pop();
                else {ans=false;break;}
            }
            else if(ch==']'){
                if(stk.peek()=='[')stk.pop();
                else {ans=false;break;}
            }
        }
        return ans;
    }
    public static boolean duplicateBracket(String input){
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch!=')'){
                stk.push(ch);
            }
            else{
                if(stk.peek()=='(')return true;
                else{
                    while(stk.peek()!='('){
                        stk.pop();
                    }
                    stk.pop();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String input=scn.nextLine();
        // System.out.println(balanceBracket(input));
        System.out.println(duplicateBracket(input));
    }

}