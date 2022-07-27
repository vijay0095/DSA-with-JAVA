
import java.io.*;
import java.util.*;

public class friendsPairing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n+1];
        // System.out.println(rec(n,dp));
        System.out.println(tab(n, dp));
    }
    
    public static int rec(int n, int[] dp){
        if(n<=2) return n;
        if(dp[n] !=0) return dp[n];
        int alone = rec(n-1,dp);
        int pair = rec(n-2,dp)*(n-1);
        int total = alone+pair;
        return dp[n]=total;
    }
    public static int tab(int n , int[] dp){
        for(int i=1; i<=n; i++){
            if(i<=2){
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2]*(i-1);
        }
        return dp[n];
    }

}