import java.io.*;
import java.util.*;

public class expression_evaluation{

    public static Stack<String> convertExpressionStringToStack (String str){
        Stack<String> stk = new Stack<>();
        String toPush="";
        for( int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if( ch == ' '){
                if( i == 0  && !toPush.equals( "" )){
                    stk.push( toPush );
                    toPush = "";
                }
                continue;
            }
            if( ch - '0' >= 0 & ch - '0' <= 9){
                toPush = ch + toPush;
                if( i == 0  ){
                    stk.push( toPush );
                    toPush = "";
                }
            }
            else if( !toPush.equals("") ){
              stk.push( toPush);
              toPush = "";
              stk.push( "" + ch );
            }
            else{
                stk.push( "" + ch );
            }
        }
        if( stk.peek().equals("-") ){
            stk.push("0");
        }
        return stk;
    }

    public static void evaluateBinaryOperatorsStack( Stack<String> stk, Stack<String> aux, String operator1, String operator2){
        while( stk.size()>0){
            String popped=stk.pop();
            if( popped.equals(operator1) || popped.equals(operator2)){
                if( stk.peek().equals("(") ){
                    aux.push( popped );
                    continue;
                }
                int fromAux = Integer.parseInt(aux.pop());
                int fromStk = Integer.parseInt(stk.pop());
                if( popped.equals("*") ){
                    int toStk = fromAux * fromStk;
                    aux.push(""+toStk);
                }
                else if( popped.equals("/") ){
                    int toStk = fromAux / fromStk;
                    aux.push(""+toStk);
                }
                else if( popped.equals("+") ){
                    int toStk = fromAux + fromStk;
                    aux.push(""+toStk);
                }
                else if( popped.equals("-") ){
                    int toStk = fromAux - fromStk;
                    aux.push(""+toStk);
                }
            }
            else if( popped.equals(")") ){
                Stack<String> inBrackets = new Stack<>();
                Stack<String> inBracketsAux = new Stack<>();
                while( aux.size()>0 && !aux.peek().equals("(") ){
                    inBrackets.push( aux.pop() );
                }
                aux.pop();
                evaluateExpressionStack( inBrackets, inBracketsAux);
                transferFromOneStackToOther( inBracketsAux, stk);
                if(aux.size()>0){
                    stk.push( aux.pop() );
                }
            }
            else{
                aux.push(popped);
            }
        }
    }
    public static void transferFromOneStackToOther( Stack< String > aux, Stack< String > stk){
        while(aux.size()>0){
            stk.push(aux.pop());
        }
    }
    public static void evaluateExpressionStack( Stack<String> stk, Stack<String> aux){
        evaluateBinaryOperatorsStack( stk, aux, "*", "/");
        transferFromOneStackToOther( aux, stk );
        evaluateBinaryOperatorsStack( stk, aux, "+", "-");
    }

  public static int evaluateExpressionString( String str){
        Stack< String > stk = convertExpressionStringToStack (str);
        Stack< String > aux = new Stack<>();
        evaluateExpressionStack( stk , aux);
        return Integer.parseInt( aux.pop() );
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int ans = evaluateExpressionString(str);
    System.out.println(ans);
    // code
 }
}