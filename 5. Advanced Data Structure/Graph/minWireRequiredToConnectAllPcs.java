
import java.io.*;
import java.util.*;

public class minWireRequiredToConnectAllPcs {
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

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(0,0,0));
      boolean[] vis = new boolean[vtces];
      while(pq.size()>0){
          Pair p = pq.remove();
          
          if(vis[p.nbr]) continue;
          
          vis[p.nbr] = true;
          if(p.src != p.nbr){
              System.out.println("["+p.nbr+"-"+p.src+"@"+p.wt+"]");
          }
          for(Edge e: graph[p.nbr]){
              if(!vis[e.nbr]){
                  pq.add(new Pair(p.nbr, e.nbr, e.wt));
              }
          }
      }
   }
   
   public static class Pair implements Comparable<Pair>{
       int src; 
       int nbr;
       int wt;
       Pair(int v, int u, int w){
           src = v;
           nbr = u;
           wt = w;
       }
       public int compareTo(Pair b){
           return this.wt - b.wt;
       }
   }

}