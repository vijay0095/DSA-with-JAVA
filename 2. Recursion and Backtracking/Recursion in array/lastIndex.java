
import java.io.*;
import java.util.*;

public class lastIndex {

  public static Scanner in = new Scanner(System.in);
  public static void input(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = in.nextInt();
    }
  }
  public static void main(String[] args) throws Exception {
    // write your code here
    int n = in.nextInt();
    int[] arr = new int[n];
    input(arr);
    int x = in.nextInt();
    System.out.println(lastIndex(arr, 0, x));
  }

  public static int lastIndex(int[] arr, int idx, int x) {
    if (idx == arr.length) {
      return -1;
    }
    int l = lastIndex(arr, idx + 1, x);
    if(l != -1) return l;
    
    return arr[idx] == x ? idx : -1;
  }

}