
import java.io.*;
import java.util.*;

public class sumOfTwoArrays{
public static Scanner in =new Scanner(System.in);
public static void input(int[] arr){
    for(int i=0;  i<arr.length; i++){
        arr[i] = in.nextInt();
    }
}
public static void main(String[] args) throws Exception {
    // write your code here
    
    int n = in.nextInt();
    int[] arr1 = new  int[n];
    input(arr1);
    int m = in.nextInt();
    int[] arr2 = new int[m];
    input(arr2);
    int[] res = addTwoArrays(arr1,arr2,n ,m );
    for(int i=0;  i<res.length; i++){
        System.out.println(res[i]);
    }
 }
 public static int[] addTwoArrays(int[] arr1, int[] arr2, int n, int m){
     int rIdx = n;
     if(rIdx < m){
         rIdx = m;
     }
     int[] res = new int[rIdx];
     int i = n-1, j = m-1, k = rIdx -1;
     int car = 0;
     while(k >=0){
         int sum  =  car;
         if(i >=0){
             sum += arr1[i];
         }
         if( j>=0){
             sum+= arr2[j];
         }
         int dig = sum %10;
         res[k] = dig;
         car = sum /10;
         i--; j--; k--;
     }
     return res;
     
 }

}