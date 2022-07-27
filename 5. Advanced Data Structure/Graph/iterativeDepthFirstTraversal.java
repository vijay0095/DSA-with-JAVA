
import java.io.*;
import java.util.*;

public class iterativeDepthFirstTraversal {
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
      Stack<Pair> st = new Stack<>();
      st.push(new Pair(src, ""+src));
      boolean[] vis = new boolean[vtces];
      while(st.size()>0){
          Pair p = st.pop();
          if(vis[p.node]) continue;
          
          vis[p.node] = true;
          System.out.println(p.node +"@"+ p.path);
          for(Edge e: graph[p.node]){
              if(!vis[e.nbr]){
                  st.push(new Pair(e.nbr, p.path + e.nbr));
              }
          }
      }
   }
   public static class Pair{
       int node ;
       String path;
       Pair(int n, String s){
           node = n;
           path = s;
       }
   }
}