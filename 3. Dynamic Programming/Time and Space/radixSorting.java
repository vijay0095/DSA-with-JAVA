
import java.io.*;
import java.util.*;

public class radixSorting {

  public static void radixSort(int[] arr) {
    // write code here
    int max = arr[0];
    for(int ele : arr) max = Math.max(max, ele);
    int exp =1;
    while(exp <= max){
        countSort(arr, exp);
        exp *= 10;
    }

  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    int[] freq = new int[10];
    for(int ele : arr){
        freq[ele / exp %10]++;
    }
    for(int i=1; i<freq.length ; i++){
        freq[i] += freq[i-1];
    }
    int[] sort = new int[arr.length];
    for(int i=arr.length -1 ; i>=0; i--){
        int fIdx = arr[i];
        int sidx = freq[fIdx / exp %10] -1;
        sort[sidx] = arr[i];
        freq[fIdx / exp % 10]--;
    }
    // int[] freq = new int[10];
    // for (int ele : arr) {
    //   int ind = ele;
    //   freq[ind / exp % 10]++;
    // }
    // for (int i = 1; i < freq.length ; i++) {
    //   freq[i] += freq[i - 1]; // prefix
    // }
    // int[] sorted = new int[arr.length];
    // for (int i = arr.length - 1 ; i >= 0; i--) {
    //   int data = arr[i];
    //   int fIdx = data ;
    //   int sIdx = freq[fIdx / exp % 10] - 1;
    //   sorted[sIdx] =  data;
    //   freq[fIdx / exp % 10]--;
    // }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sort[i];
    }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
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
    radixSort(arr);
    print(arr);
  }

}