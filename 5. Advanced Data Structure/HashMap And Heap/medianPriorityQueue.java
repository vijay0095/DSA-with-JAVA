
import java.io.*;
import java.util.*;

public class medianPriorityQueue {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }
    
    private void balance(){
        if(left.size() +1 == right.size()){
            left.add(right.remove());
        }
        if(left.size() -2 == right.size()){
            right.add(left.remove());
        }
    }

    public void add(int val) {
      // write your code here
      if(left.size() ==0 || left.peek()>val){
          left.add(val);
      }else{
          right.add(val);
      }
      balance();
    }

    public int remove() {
      // write your code here
      if(size() ==0){
          System.out.println("Underflow");
          return -1;
      }
      int val = left.remove();
      balance();
      return val;
    }

    public int peek() {
      // write your code here
      if(size() ==0){
          System.out.println("Underflow");
          return -1;
      }
      return left.peek();
    }

    public int size() {
      // write your code here
      return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}