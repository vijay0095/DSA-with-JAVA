
import java.io.*;
import java.util.*;

public class infixConversions{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> value1 = new Stack<>();
    Stack<String> value2 = new Stack<>();
    Stack<Character> operator = new Stack<>();
    
    for(int i=0; i<exp.length(); i++){
        char ch = exp.charAt(i);
        if('a' <= ch && ch <= 'z'){
            value1.push(ch+"");
            value2.push(ch +"");
        }else if(ch == '('){
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.peek() != '(') solve(value1,value2, operator);
            operator.pop();
        }else if(ch != ' '){
            while(operator.size() > 0 && priority(operator.peek())>= priority(ch) && operator.peek() != '(' ) solve(value1,value2, operator);
            operator.push(ch);
        }
    }
    while(operator.size()>0){
        solve(value1,value2, operator);
    }
    System.out.println(value2.pop());
    System.out.println(value1.pop());
 }
 
 static void solve(Stack<String> value1,Stack<String> value2, Stack<Character> operator){
     String v2 = value1.pop();
     String v1 = value1.pop();
     char ch = operator.pop();
     value1.push(ch + v1+v2);
      v2 = value2.pop();
      v1 = value2.pop();
     value2.push(v1+v2+ch);
     
 }
 static int priority(char ch){
     if(ch == '*' || ch == '/') return 1;
     return 0;
 }
 
 
}