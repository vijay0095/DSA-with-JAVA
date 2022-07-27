
import java.io.*;
import java.util.*;

public class quickSelect {

  public static int quickSelect_(int[] arr, int lo, int hi, int k) {
    //write your code here
    if(lo > hi){
        return -1;
    }
    int x = arr[k];
    int pt = partition(arr, arr[hi], lo, hi);
    if(pt == k){
        return arr[pt];
    }else if(pt < k){
        x = quickSelect_(arr, pt + 1, hi, k);
    }else{
        x = quickSelect_(arr, lo, pt -1, k);
    }

    return x;
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    System.out.println("pivot -> " + pivot);
    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
    System.out.println("pivot index -> " + (j - 1));
    return (j - 1);
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(quickSelect_(arr,0,arr.length - 1,k - 1));
  }

}