
import java.io.*;
import java.util.*;

public class breadthFirstTraversal {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(src, ""+src));
      boolean[] vis = new boolean[vtces];
      while(q.size()>0){
          Pair p = q.remove();
          if(!vis[p.src]){
              System.out.println(p.src+"@"+ p.path);
              for(Edge e: graph[p.src]){
                  if(!vis[e.nbr]){
                      q.add(new Pair(e.nbr, p.path + e.nbr));
                  }
              }
          }
          vis[p.src] =true;
      }
   }
   
   public static class Pair{
       int src;
       String path;
       Pair(int n, String s){
           src = n;
           path = s;
       }
   }
}