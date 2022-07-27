
import java.io.*;
import java.util.*;

public class writePriorityQueueUsingHeap {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    private void upheapify(int i){
        while(i>0){
            int pi = (i-1)/2;
            if(isSmaller(data.get(i), data.get(pi))){
                swap(i, pi);
            }else{
                break;
            }
            i=pi;
        }
    }
    
    private boolean isSmaller(int a, int b){
        return a<b;
    }
    private void swap(int i, int j){
        int t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size() -1);
    }
    private void downheapify(int i){
        while(true){
            int li = 2*i +1;
            int ri = 2* i+2;
            int min = i;
            if(li <data.size() && isSmaller(data.get(li), data.get(min))){
                min = li;
            }
            if(ri<data.size() && isSmaller(data.get(ri), data.get(min))){
                min = ri;
            }
             if(i==min) break;
            swap(i, min);
            i = min;
           
        }
    }

    public int remove() {
      // write your code here
      if(size()==0){
          System.out.println("Underflow");
          return -1;
      }
      swap(0, data.size()-1);
      int val = data.remove(data.size()-1);
      downheapify(0);
      return val;
    }

    public int peek() {
      // write your code here
      if(size()==0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

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