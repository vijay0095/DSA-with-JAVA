
import java.io.*;
import java.util.*;

public class partitionIntoSubsets {
        
    public static long ways(int n, int k) {
        // write your code here
        if(n==k) return 1;
        if(n < k || k==0) return 0;
        long ans = 0;
        ans = k*ways(n-1, k)  + ways(n-1, k-1);
        
        return ans;
        
    }
    
    public static long ways(int n , int k , long[][] dp){
        if(n==k) return 1;
        if(n < k || k==0) return 0;
        if(dp[n][k] != 0) return dp[n][k];
        long ans = 0;
        ans = k*ways(n-1, k)  + ways(n-1, k-1);
        
        return dp[n][k] = ans;
    }
    
    public static long Ways(int N, int K){
        long[][] dp = new long[N+1][K+1];
        for(int n =0; n<=N; n++){
            for(int k=0; k<=K; k++){
                if(n==k){
                    dp[n][k] = 1;
                }else if(n<k){
                    dp[n][k] = 0;
                }else if(k==0){
                    dp[n][k] = 0;
                }else{
                    dp[n][k] = dp[n-1][k] *k + dp[n-1][k-1];
                }
            }
        }
        return dp[N][K];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long[][] dp = new long[n+1][k+1];
        // long res = ways(n, k,dp);
        long res = Ways(n,k);
        System.out.println(res);
    }
}