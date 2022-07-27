
import java.io.*;
import java.util.*;

public class subsetsOfArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
     for(int i=0; i<n; i++){
         arr[i] = in.nextInt();
     }
     int r = (int)Math.pow(2,n);
     for(int i = 0 ; i<r; i++){
        int pow = (int)Math.pow(10,n-1);
        int bn = dtb(i);
        for(int j =0 ; j<n; j++){
            int rem = bn/pow;
            if(rem == 1){
                System.out.print(arr[j]+"	");
            }else{
                System.out.print("-	");
            }
            bn = bn % pow;
            pow /=10;
        }
        System.out.println();
     }
 }
 public static int dtb(int n){
     int ans =0, pow = 1;
     while(n>0){
         int rem = n%2;
         ans += rem * pow;
         n/=2;
         pow *=10;
     }
     return ans;
 }

}