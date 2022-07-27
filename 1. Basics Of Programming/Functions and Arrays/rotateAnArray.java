
import java.io.*;
import java.util.*;

public class rotateAnArray{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k){
    // write your code here
    int n = a.length;
    k = k%n;
    if(k<0) k+=n;
    reverse(a, 0, n-1);
    reverse(a,0,k-1);
    reverse(a, k, n-1);
    
    
  }
  public static void reverse(int[] arr, int l, int r){
      while(l<r){
          int t = arr[l];
          arr[l] = arr[r];
          arr[r] = t;
          l++;  r--;
      }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}