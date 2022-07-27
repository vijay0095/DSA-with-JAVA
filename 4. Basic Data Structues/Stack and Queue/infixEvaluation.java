
import java.io.*;
import java.util.*;

public class infixEvaluation{
  
 public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    int val= infix_eval(exp);
    System.out.println(val);
 }
 
 public static int infix_eval(String exp){
     Stack< Integer> operand= new Stack<>();
     Stack< Character> operator= new Stack<>();
     
     for(int i= 0; i< exp.length(); i++){
         char ch= exp.charAt(i);
         if(ch== '('){
             operator.push(ch);
         }
         else if(ch>= '0' && ch<= '9'){
             operand.push(ch- '0');
         }
         else if(ch== ')'){
             while(operator.peek()!= '('){
                 char opr= operator.pop();
                 int b= operand.pop();
                 int a= operand.pop();
                 
                 int val= calculate(a, b, opr);
                 
                 operand.push(val);
             }
             operator.pop();
         }
         else if(ch== '+' || ch== '-' || ch== '/' || ch== '*'){
             while(operator.size()> 0 && operator.peek()!= '(' && precedence(ch)<= precedence(operator.peek())){
                 char opr= operator.pop();
                 int b= operand.pop();
                 int a= operand.pop();
                 
                 int val= calculate(a, b, opr);
                 operand.push(val);
             }
             operator.push(ch);
         }
     }
     
     while(operator.size()> 0){
         char opr= operator.pop();
         int b= operand.pop();
         int a= operand.pop();
         
         int val= calculate(a, b, opr);
         operand.push(val);
     }
     
     return operand.pop();
     
 }
 
 public static int calculate(int a, int b, char opr){
     if(opr== '+'){
         return a+ b;
     }
     else if(opr== '-'){
         return a- b;
     }
     else if(opr== '*'){
         return a* b;
     }
     else{
         return a/ b;
     }
     
 }
 
 public static int precedence(char ch){
     if(ch== '+' || ch== '-'){
         return 1; 
     }
     else {
         return 2; 
     }
     
 }
 
}