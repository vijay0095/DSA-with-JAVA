
import java.io.*;
import java.util.*;

public class countSorting {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   int[] freq = new int[max - min +1];
   for(int ele : arr){
       int ind = ele - min;
       freq[ind]++;
   }
   for(int i= 1; i<freq.length ; i++){
       freq[i] += freq[i - 1];
   }
   int[] sorted = new int[arr.length];
   for(int i=arr.length-1 ; i>=0; i--){
       int data = arr[i];
       int fIdx = data - min;
       int sIdx = freq[fIdx] - 1;
       sorted[sIdx] =  data;
       freq[fIdx]--;
   }
   for(int i=0; i<arr.length; i++){
       arr[i] = sorted[i];
   }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}