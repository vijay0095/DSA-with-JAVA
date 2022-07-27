
import java.io.*;
import java.util.*;

public class mergeTwoSortedArrays {

  public static int[] mergeTwoSortedArrays_(int[] a, int[] b){
    //write your code here
    int n = a.length, m = b.length;
    int[] arr = new int[n+m];
    int i =0, j=0, k=0;
    while(k<arr.length){
        if(i<n && j<m){
            if(a[i]<b[j]){
                arr[k++] = a[i++];
            }else{
                arr[k++] = b[j++];
            }
        }else if(i<n){
            arr[k++] = a[i++];
        }else if(j<m){
            arr[k++] = b[j++];
        }
    }
    
    return arr;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays_(a,b);
    print(mergedArray);
  }

}