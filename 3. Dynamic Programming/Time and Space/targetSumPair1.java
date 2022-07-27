
import java.io.*;
import java.util.*;

public class targetSumPair1 {

  public static void targetSumPair(int[] arr, int target){
    //write your code here
    arr = mergeSort(arr,0 , arr.length -1);
    int si = 0, ei = arr.length -1;
    int p1 = arr[si], p2 = arr[ei];
    while(si <ei){
        
        int sum = arr[si] + arr[ei];
        if(sum < target){
            si++;
        }else if(sum > target){
            ei--;
        }else{
            System.out.println(arr[si]+", "+ arr[ei]);
            si++; ei--;
        while(si < ei && arr[si] == p1){
            si++;
        }
        p1 = arr[si];
        while(si < ei && arr[ei] == p2){
            ei--;
        }
        p2 = arr[ei];
        }
    }

  }
    public static int[] mergeSort(int[] arr, int lo, int hi) {
    //write your code here
    if(lo==hi){
        return new int[]{arr[lo]};
    }
    int mid = (lo + hi)/2;
    int[] a1 = mergeSort(arr, lo, mid);
    int[] a2 = mergeSort(arr, mid + 1, hi);

    return mergeTwoSortedArrays(a1,a2);
  }

  //used for merging two sorted arrays
  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    int i = 0, j =0, k = 0;
    int[] ans = new int[a.length + b.length];
    while(i < a.length && j < b.length){
        if(a[i] <= b[j]){
          ans[k] = a[i];
          i++;
          k++;
        }else{
          ans[k] = b[j];
          j++;
          k++;
        }
    }

    while(i < a.length){
      ans[k] = a[i];
      k++;
      i++;
    }

    while(j < b.length){
      ans[k] = b[j];
      k++;
      j++;
    }
    
    return ans;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}