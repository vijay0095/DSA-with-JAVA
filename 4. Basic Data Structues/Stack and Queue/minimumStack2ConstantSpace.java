
import java.io.*;
import java.util.*;

public class minimumStack2ConstantSpace {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      // write your code here
      return data.size();
    }

    void push(int val) {
      // write your code here
      if(size() == 0){
          data.push(val);
          min = val;
      }else{
          if(val < min){
              data.push(val+val -min); // encoded value
              min = val;
          }else{
              data.push(val);
          }
      }
    }

    int pop() {
      // write your code here
      if(size() == 0 ){
          System.out.println("Stack underflow");
          return -1;
      }
      int val = data.pop();
      if(val < min){
          int pmin = 2 * min - val;
          int ov = min;
          min = pmin;
          return ov;
      }else{
          return val;
      }
    }

    int top() {
      // write your code here
      if(size() == 0 ){
          System.out.println("Stack underflow");
          return -1;
      }
      int val = data.peek();
      if(val < min){
         return min;
      }else{
          return val;
      }
    }

    int min() {
      // write your code here
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}