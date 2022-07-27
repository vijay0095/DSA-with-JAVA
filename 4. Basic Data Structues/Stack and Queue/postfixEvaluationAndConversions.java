
import java.io.*;
import java.util.*;

public class postfixEvaluationAndConversions{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> pre = new Stack<>();
    Stack<String> inf = new Stack<>();
    Stack<Integer> value = new Stack<>();
    
    for(int i=0; i<exp.length(); i++){
        char ch = exp.charAt(i);
        if('0'<=ch && ch<='9'){
            pre.push(ch+"");
            inf.push(ch+"");
            value.push(ch - '0');
        }else{
            solve(pre, inf, value,ch);
        }
    }
    System.out.println(value.pop());
    System.out.println(inf.pop());
    System.out.println(pre.pop());
 }
 
 static void solve(Stack<String> pre, Stack<String> inf, Stack<Integer> value, char ch){
     
     String v2 = pre.pop();
     String v1 = pre.pop();
     pre.push(ch + v1+v2);
     v2 = inf.pop();
     v1 = inf.pop();
     inf.push("("+v1 + ch + v2+")");
     int a = value.pop();
     int b = value.pop();
     if(ch == '+'){
         value.push(b+a);
     }else if(ch == '-'){
         value.push(b - a);
     }else if(ch == '*'){
         value.push(b*a);
     }else {
         value.push(b/a);
     }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
}