
import java.io.*;
import java.util.*;

public class getConnectedComponentsOfAGraph {
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      boolean[] vis = new boolean[vtces];
      for(int i=0; i<vtces; i++){
          if(!vis[i]){
            //   ArrayList<Integer> c = new ArrayList<>();
            //   getComp(graph, i, vis, c);
            //   comps.add(c);
            comps.add(getComp(i, graph, vis));
          }
          
            
      }
        
      System.out.println(comps);
   }
   
   public static ArrayList<Integer> getComp(int src, ArrayList<Edge>[] graph, boolean[] vis){
       ArrayList<Integer> ans = new ArrayList<>();
       vis[src] = true;
       ans.add(src);
       for(Edge e: graph[src]){
           if(!vis[e.nbr]){
               ArrayList<Integer> rans = getComp(e.nbr, graph, vis);
               for(int i=0; i<rans.size(); i++){
                   ans.add(rans.get(i));
               }
           }
       }
       return ans;
   }
   
   public static void getComp(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> c){
       vis[src] =true;
       c.add(src);
       for(Edge e: graph[src]){
           if(!vis[e.nbr])
                getComp(graph, e.nbr, vis, c);
       }
   }
   
   
}