
import java.io.*;
import java.util.*;

public class shortestPathInWeights {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, ""+src, 0));
      boolean vis[]= new boolean[vtces];
      while(pq.size()>0){
          Pair p = pq.remove();
          
          if(vis[p.node]) continue;
          vis[p.node] = true;
          System.out.println(p.node +" via "+ p.path +" @ "+ p.wt);
          for(Edge e: graph[p.node]){
              if(!vis[e.nbr]){
                  pq.add(new Pair(e.nbr, p.path + e.nbr, p.wt + e.wt));
              }
          }
      }
      
   }
   
   public static class Pair implements Comparable<Pair>{
       int node;
       String path;
       int wt;
       Pair(int n, String p, int w){
           node = n;
           path = p;
           wt = w;
       }
       public int compareTo(Pair b){
           return this.wt - b.wt;
       }
   }
}