
import java.io.*;
import java.util.*;

public class balancedBrackets {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s= in.nextLine();
        Stack<Character> st = new Stack<>();
        boolean res = true;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch== '{' || ch == '['){
                st.push(ch);
            }
            else if(ch==')')
            {
                if(st.size()==0 || st.peek() != '('){
                    res = false;
                    break;
                }
                st.pop();
            }else if(ch == '}'){
                if(st.size()==0 || st.peek() != '{'){
                    res = false;
                    break;
                }
                st.pop();
            }else if(ch == ']'){
                if(st.size()==0 ||st.peek() != '['){
                    res = false;
                    break;
                }
                st.pop();
            }
        }
        if(res == false){
            System.out.println(false);
        }else
        System.out.println(st.size()==0);
    }

}