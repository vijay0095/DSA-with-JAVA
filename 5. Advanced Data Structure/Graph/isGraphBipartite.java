
import java.io.*;
import java.util.*;

public class isGraphBipartite {
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
    int visited[] = new int[vtces];


    boolean ok = true;
    Arrays.fill(visited, -1);

    for (int i = 0; i < vtces; i++) {
      if (visited[i] == -1) {
        ok = bipartite(graph, i, visited);
        if (ok == false)break;
      }
    }
    System.out.println(ok);
  }

  static boolean bipartite(ArrayList<Edge>[] graph, int src, int visited[]) {
    Queue<Pair> q = new LinkedList<>();


    q.add(new Pair(src, 0));

    while (q.size() > 0) {

      Pair p = q.remove();

      if (visited[p.node] != -1) {
        if (visited[p.node] != p.c) {
          return false;
        }
        continue;
      }

      visited[p.node] = p.c;

      for (Edge ed : graph[p.node]) {
        if (visited[ed.nbr] == -1) {
          q.add(new Pair(ed.nbr, 1 - p.c));
        }
      }
    }

    return true;
  }

  static class Pair {
    int node;
    int c;

    Pair(int n, int c) {
      node = n;
      this.c = c;
    }
  }
}