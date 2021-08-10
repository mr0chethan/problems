import java.io.*;
import java.util.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class expression_evaluation{
    public static class StackUsingArray<DataType>{
        protected ArrayList<DataType>arr;
        private int size;
        private int tos;
        public StackUsingArray(){
            this.arr=new ArrayList<>();
            this.size=0;
            this.tos=-1;
        }
        @Override
        public String toString(){
            StringBuilder sb=new StringBuilder();
            sb.append('[');
            for(int i=this.tos;i>=0;i--){
                sb.append(this.arr.get(i));
                if(i!=0){
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public int size(){
            return this.size;
        }

        public DataType peek(){
            return this.arr.get(this.tos);
        }

        public void push(DataType data){
            this.arr.add(data);
            this.tos++;
            this.size++;
        }
        
        public DataType pop(){
            DataType val=this.arr.get(this.tos);
            this.arr.remove(this.tos);
            this.tos--;
            this.size--;
            return val;
        } 
    }
    public static boolean checkPeekValues( char peekValue, char[] peekValues ){
        if( peekValues.length == 0){
            return true;
        }
        for( int i = 0; i < peekValues.length; i++){
            if( peekValue == peekValues[ i ]){
                return true;
            }
        }
        return false;
    }

    public static  void operate( StackUsingArray<Integer> operands, StackUsingArray< Character > operators, char[] peekValues) {
        while( operators.size() > 0 && checkPeekValues( operators.peek(), peekValues) ){
            char poppedOperator = operators.pop();
            int upperOperand = operands.pop();
            int lowerOperand = operands.pop();
            if( poppedOperator == '*' ){
                operands.push( lowerOperand * upperOperand );
            }
            else if( poppedOperator == '/' ){
                operands.push( lowerOperand / upperOperand );
            }
            else if( poppedOperator == '+' ){
                operands.push( lowerOperand + upperOperand );
            }
            else if( poppedOperator == '-' ){
                operands.push( lowerOperand - upperOperand );
            }
        }
    }

    public static int calculate ( String str ) {
        StackUsingArray<Integer> operands = new StackUsingArray();
        StackUsingArray< Character > operators = new StackUsingArray();
        String toStack = "";
        for( int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if( ch == ' '){
                continue;
            }
            else if( ch >= '0'&& ch<= '9' ){ 
                toStack += ch;
            }
            else if( ch == '('){
                    operators.push( ch );
            }
            else{
                if( !toStack.equals("") ){
                    operands.push( Integer.parseInt( toStack ) );
                    toStack = "";
                }
                if( ch == '-'){
                    if( i>0 && str.charAt(i-1)=='-'){
                        if(operands.peek()==-1 && operators.peek()=='*'){
                            operands.pop();
                            operators.pop();
                            operators.push('+');
                        }
                        else if( operators.peek() == '-'){
                            operators.pop();
                            operators.push('+');
                        }
                        else if( operators.peek() == '+'){
                            operators.pop();
                            operators.push('-');
                        }
                    }
                    else{
                        operands.push(-1);
                        operators.push('*');
                    } 
                }
                if( ch == '*' || ch == '/'){
                    char[] peekValues = {'*','/'};
                    operate( operands, operators, peekValues);
                    operators.push( ch );
                }
                else if( ch == '+' ){//|| ch == '-'
                    char[] peekValues = {'*','/','+','-'};
                    operate( operands, operators, peekValues);
                    operators.push( ch );
                }
                else if( ch == ')' ){
                    char[] peekValues = {'*','/','+','-'};
                    operate( operands, operators, peekValues);
                    operators.pop();
                }
            }
        }
        if( !toStack.equals("") ){
            operands.push( Integer.parseInt( toStack ) );
            toStack = "";
        }
        operate( operands, operators, new char[0]);
        return operands.pop();
    }

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
              if(ch == '-'){
                stk.pop();
                stk.push("*");
                stk.push("-1");
                }
            }
            else{
                stk.push( "" + ch );
                if(i>0 && str.charAt(i-1) == '-' && ch == '-'){
                    stk.pop();
                    stk.push("*");
                    stk.push("-1");
                    }
            }
        }
        System.out.println(stk);
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
    // int ans = calculate( str );
    System.out.println(ans);
    // ScriptEngineManager mgr = new ScriptEngineManager();
    // ScriptEngine engine = mgr.getEngineByName("JavaScript");
    // System.out.println(engine.eval(str));
 }
}