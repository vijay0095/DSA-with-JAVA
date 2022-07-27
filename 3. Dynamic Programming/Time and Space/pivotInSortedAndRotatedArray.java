
import java.io.*;
import java.util.*;

public class pivotInSortedAndRotatedArray {

  public static int findPivot(int[] arr) {
    // write your code here
    int si =0 , ei = arr.length -1 ;
    while(si < ei){
        int mid = (si+ei)/2;
        if(arr[mid]<arr[ei]){
            ei = mid;
        }else{
            si = mid + 1;
        }
    }
    return arr[si];
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = findPivot(arr);
    System.out.println(pivot);
  }

}