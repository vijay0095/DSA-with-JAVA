
import java.io.*;
import java.util.*;

public class perfectFriends {

   public static void main(String[] args) throws Exception {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int k =in.nextInt();
       ArrayList<Integer>[] graph = new ArrayList[n];
       for(int i=0; i<n; i++){
           graph[i] = new ArrayList<>();
       }
       for(int i=0; i<k; i++){
           int src = in.nextInt();
           int nbr = in.nextInt();
           graph[src].add(nbr);
           graph[nbr].add(src);
       }
       
       ArrayList<Integer> sz = new ArrayList<>();
       boolean[] vis = new boolean[n];
       for(int i=0; i<n; i++){
           if(!vis[i]){
               ArrayList<Integer> cmp = new ArrayList<>();
               rec(i, graph, vis, cmp);
               sz.add(cmp.size());
           }
       }
       int sum = n;
       int ans =0;
       for(int i=0; i<sz.size(); i++){
           sum -= sz.get(i);
           ans += sum*sz.get(i);
       }
       System.out.println(ans);
   }
   
   public static void rec(int src, ArrayList<Integer>[] graph, boolean[] vis, ArrayList<Integer> cmp){
       vis[src] = true;
       cmp.add(src);
       for(int nbr : graph[src]){
           if(!vis[nbr]){
               rec(nbr, graph, vis, cmp);
           }
       }
   }

}