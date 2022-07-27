
import java.io.*;
import java.util.*;

public class isGraphicCyclic {
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
      boolean[] vis = new boolean[vtces];
      boolean res = false;
      for(int i=0; i<vtces; i++){
          if(!vis[i]){
            //   res = hasCycleDFS(graph, i, -1, vis);
              res = hasCycleBFS(graph, i, vis);
          }
          if(res) break;
      }
      System.out.println(res);
   }
   
   public static boolean hasCycleBFS(ArrayList<Edge>[] graph, int src, boolean[] vis){
       Queue<Integer> q = new LinkedList<>();
       q.add(src);
       while(q.size()>0){
           Integer rm = q.remove();
           if(vis[rm]) return true;
           
           vis[rm] = true;
           
           for(Edge e: graph[rm]){
               if(!vis[e.nbr]){
                    q.add(e.nbr);
               }
           }
       }
       return false;
   }
   
   public static boolean hasCycleDFS(ArrayList<Edge>[] graph, int src, int par, boolean[] vis){
       vis[src] = true;
       for(Edge e: graph[src]){
           if(e.nbr == par) continue;
           if(vis[e.nbr]) return true;
           hasCycleDFS(graph, e.nbr, src, vis);
       }
       return false;
   }
}