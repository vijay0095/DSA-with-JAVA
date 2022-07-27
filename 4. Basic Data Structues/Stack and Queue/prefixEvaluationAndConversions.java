
import java.io.*;
import java.util.*;

public class prefixEvaluationAndConversions{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> post = new Stack<>();
    Stack<String> inf = new Stack<>();
    Stack<Integer> value = new Stack<>();
    
    for(int i=exp.length()-1; i>=0; i--){
        char ch = exp.charAt(i);
        if('0'<=ch && ch<='9'){
            post.push(ch+"");
            inf.push(ch+"");
            value.push(ch - '0');
        }else{
            solve(post, inf, value,ch);
        }
    }
    System.out.println(value.pop());
    System.out.println(inf.pop());
    System.out.println(post.pop());
 }
 
 static void solve(Stack<String> post, Stack<String> inf, Stack<Integer> value, char ch){
     
     String v2 = post.pop();
     String v1 = post.pop();
     post.push( v2+v1 + ch);
     v2 = inf.pop();
     v1 = inf.pop();
     inf.push("("+v2 + ch + v1+")");
     int a = value.pop();
     int b = value.pop();
     if(ch == '+'){
         value.push(b+a);
     }else if(ch == '-'){
         value.push(a - b);
     }else if(ch == '*'){
         value.push(b*a);
     }else {
         value.push(a/b);
     }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
}