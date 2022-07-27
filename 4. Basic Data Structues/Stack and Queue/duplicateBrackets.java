
import java.io.*;
import java.util.*;

public class duplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s= in.nextLine();
        Stack<Character> st = new Stack<>();
        boolean res = false;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(st.peek() == '('){
                    res = true;
                }else{
                    while(st.peek() != '(') st.pop();
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        System.out.println(res);
    }

}