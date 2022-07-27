
import java.io.*;
import java.util.*;

public class brokenEconomy {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n =  in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    int d = in.nextInt();
    int left = 0,  right = n - 1, idx = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] == d) {
        System.out.println(arr[mid]);
        System.out.println(arr[mid]);

        return;
      } else if (arr[mid] < d) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if(left >=0 && left<n){
        System.out.println(arr[left]);
    }else{
        System.out.println(-1);
    }
    if(right >0 && right<arr.length){
        System.out.println(arr[right]);
    }else{
        System.out.println(-1);
    }
  }

}