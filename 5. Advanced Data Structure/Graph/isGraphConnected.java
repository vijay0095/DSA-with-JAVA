
import java.io.*;
import java.util.*;

public class isGraphConnected {
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
      int count =0;
      for(int i=0; i<vtces; i++){
          if(!vis[i]){
              count++;
              getComp(i,graph, vis);
          }
      }
      System.out.println(count==1);
    //   getComp(0, graph, vis);
    //   for(int i=0; i<vtces; i++){
    //       if(vis[i] == false){
    //           System.out.println(false);
    //           return;
    //       }
    //   }
    //   System.out.println(true);
    
   }
   
   public static void getComp(int src, ArrayList<Edge>[] graph, boolean[] vis){
       vis[src] =true;
       for(Edge e: graph[src]){
           if(!vis[e.nbr])
                getComp(e.nbr,graph, vis);
       }
   }
   
   
}