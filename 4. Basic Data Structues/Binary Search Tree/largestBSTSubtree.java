
import java.io.*;
import java.util.*;

public class largestBSTSubtree {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static class pair{
      int min;
      int max;
      int lsize;
      int ldata;
      int size;
      boolean ok;
  }
  
  public static pair func(Node node){
      if(node == null){
          pair b = new pair();
          b.min = Integer.MAX_VALUE;
          b.max = Integer.MIN_VALUE;
          b.size = 0;
          b.lsize = 0;
          b.ldata = 0;
          b.ok = true;
          return b;
      }
      pair l = func(node.left);
      pair r = func(node.right);
      
      pair ans = new pair();
      if(l.lsize >= r.lsize){
          ans.lsize = l.lsize;
          ans.ldata = l.ldata;
      }else{
          ans.lsize = r.lsize;
          ans.ldata = r.ldata;
      }
      if(l.max < node.data && r.ok && l.ok){
          ans.ok = true;
          ans.lsize = l.size + r.size +1;
          ans.ldata = node.data;
      }else{
          ans.ok = false;
      }
      ans.min = Math.min(l.min, node.data);
      ans.max = Math.max(r.max, node.data);
      ans.size = l.size + r.size +1;
      return ans;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    pair p = func(root);
    System.out.println(p.ldata +"@"+p.lsize);
  }

}