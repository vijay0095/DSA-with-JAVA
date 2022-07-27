
import java.io.*;
import java.util.*;

public class mergeOverlappingInterval {

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];

    for (int j = 0; j < n; j++) {
      String line = br.readLine();
      arr[j][0] = Integer.parseInt(line.split(" ")[0]);
      arr[j][1] = Integer.parseInt(line.split(" ")[1]);
    }

    mergeOverlappingIntervals(arr);
  }

  public static void mergeOverlappingIntervals(int[][] arr) {
    // merge overlapping intervals and print in increasing order of start time
     Pair[] p = new Pair[arr.length];
     for(int i=0; i<arr.length; i++){
         p[i] = new Pair(arr[i][0], arr[i][1]);
     }
     Arrays.sort(p);
     
     Stack<Pair> st = new Stack<>();
     st.push(p[0]);
     for(int i=1; i<p.length; i++){
         Pair top = st.peek();
          if(p[i].st > top.et){
              st.push(p[i]);
          }else{
              top.et = Math.max(top.et, p[i].et);
          }
     }
     Stack<Pair> ans = new Stack<>();
     while(st.size()>0){
         ans.push(st.pop());
     }
     while(ans.size()>0){
         Pair x= ans.pop();
         System.out.println(x.st +" "+x.et);
     }
  }

  public static  class Pair implements Comparable<Pair> {
    int st;
    int et;
    Pair(int s, int e) {
      st = s;
      et = e;
    }
    public int compareTo(Pair b) {
      return this.st - b.st;
    }
  }

}