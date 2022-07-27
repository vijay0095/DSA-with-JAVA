
import java.io.*;
import java.util.*;

public class printAllPaths {
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
      int dest = Integer.parseInt(br.readLine());

      // write all your codes here
      boolean[] vis = new boolean[vtces];
      allpath(graph, src, dest, vis, "");
   }
   
   public static void allpath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis, String asf){
       if(src == des){
           System.out.println(asf+des);
           return;
       }
       vis[src] = true;
       for(Edge e: graph[src]){
           if(!vis[e.nbr]){
               allpath(graph, e.nbr, des, vis, asf+src);
           }
       }
       vis[src] = false;
   }
   
}