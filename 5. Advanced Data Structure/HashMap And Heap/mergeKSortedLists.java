
import java.io.*;
import java.util.*;

public class mergeKSortedLists {
    public static class Pair implements Comparable<Pair>{
        ArrayList<Integer> arr;
        int idx;
        Pair(ArrayList<Integer> a){
            arr = a;
            idx =0;
        }
        
        public int compareTo(Pair b){
            int x = this.arr.get(idx);
            int y = b.arr.get(b.idx);
            
            return x-y;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(ArrayList<Integer> list : lists){
          pq.add(new Pair(list));
      }
      while(pq.size()>0){
          Pair p = pq.remove();
          rv.add(p.arr.get(p.idx));
          p.idx++;
          if(p.idx < p.arr.size()){
              pq.add(p);
          }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}