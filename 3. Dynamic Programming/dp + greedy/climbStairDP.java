
import java.io.*;
import java.util.*;

public class climbStairDP {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // int count = cs(n, new int[n+1]);
        // int count = cs(n);
        // int[] dp = new int[n+1];
        // System.out.println(rec(n,dp));
        System.out.println(tab(n));
        // int[] dp = new int[n+1];
        // for(int i=0; i<=n; i++){
        //     if(i==0){
        //         dp[i] = 1;
        //         continue;
        //     }
        //     if(i<=2){
        //         dp[i] = i;
        //         continue;
        //     }
        //     dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        // }
        // System.out.println(dp[n]);
    }
    public static int tab(int N){
        int[] dp = new int[N+1];
        for(int n=0; n<=N; n++){
            if(n==0){
                dp[n] = 1;
                continue;
            }
            if(n<=2){
                dp[n] = n;
                continue;
            }
            
                dp[n] = dp[n-1]+dp[n-2]+dp[n-3];
            
        }
        return dp[N];
    }
    public static int rec(int n,int[] dp ){
        if(n==0){
            return 1;
        }
        if(dp[n] != 0){ 
            // System.out.println("->"+n);
            return dp[n];
            
        }
        int c =0;
        if(n-1>=0){
            c+=rec(n-1,dp);
        }
        if(n-2>=0){
            c+=rec(n-2,dp);
        }
        if(n-3>=0){
            c+=rec(n-3,dp);
        }
        return dp[n] = c;
    }
    static int cs(int n , int[] dp){
        if(n == 0) return 1;
        if(n<0) return 0;
        if(dp[n]> 0) return dp[n];
        int ans = cs(n-1, dp) + cs(n-2, dp) + cs(n-3, dp);
        dp[n] = ans;
        return dp[n];
    }
    static int cs(int n){
        if(n == 0) return 1;
        if(n<0) return 0;
        
        int ans = cs(n-1) + cs(n-2) + cs(n-3);
        
        return ans;
    }
   
}