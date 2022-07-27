
import java.io.*;
import java.util.*;

public class fibonacci_DP{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in  = new Scanner(System.in);
    int n = in.nextInt();
    // int nthfib = fibo(n);
    
    int nthfib = fibo(n, new int[n+1]);
    System.out.println(nthfib);
 }
 static int fibo(int n){
     if(n<=1) return n;
     
     int one = fibo(n-1);
     int two = fibo(n-2);
     int ans = one+ two;
     return ans;
 }
 static int fibo(int n, int[] qb){
     if(n<=1) return n;
     if(qb[n] > 0) return qb[n];
     int one = fibo(n-1, qb);
     int two = fibo(n-2, qb);
     int ans = one + two;
     qb[n] = ans;
     return qb[n];
 }

}