
import java.io.*;
import java.util.*;

public class differenceOfTwoArrays{
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
    int[] res = subTwoArrays(arr1,arr2,n ,m );
    int i=0;
    while(res[i] ==0 && i<res.length -1){
        i++;
    }
    for(int k=i;  k<res.length ; k++){
        System.out.println(res[k]);
    }
    // System.out.println(res[i-1]);
 }
 public static int[] subTwoArrays(int[] arr1, int[] arr2, int n, int m){
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
             sum -= arr1[i];
         }
         if( j>=0){
             sum+= arr2[j];
         }
         if(sum < 0){
             sum += 10;
             car = -1;
         }else{
             car =  0;
         }
         int dig = sum %10;
         res[k] = dig;
         
         i--; j--; k--;
     }
     return res;
     
 }

}