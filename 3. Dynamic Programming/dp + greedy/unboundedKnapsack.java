
import java.io.*;
import java.util.*;

public class unboundedKnapsack {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
       
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }

        int[] wts = new int[n];
     
        for (int i = 0; i < n; i++) {
            wts[i] = in.nextInt();
        }

        int cap = in.nextInt();
        int[] dp = new int[cap+1];
        System.out.println(recM(values, wts, 0,cap, dp));
        
    }
    public static int rec(int[] v, int[] w, int idx,  int cap){
        if(cap == 0 || idx == v.length) return 0;
        int ans = 0;
        if(cap-w[idx] >= 0){
            ans = Math.max(ans, rec(v,w,idx, cap-w[idx]) + v[idx]);
        }
        ans = Math.max(ans,rec(v,w,idx+1, cap));
        return ans;
    }
    public static int recM(int[] v, int[] w, int idx,  int cap,int[] dp){
        if(cap == 0 || idx == v.length) return 0;
        int ans = 0;
        if(dp[cap]!=0 ) return dp[cap];
        if(cap-w[idx] >= 0){
            ans = Math.max(ans, recM(v,w,idx, cap-w[idx],dp) + v[idx]);
            // dp[cap-w[idx]] = ans;
        }
        ans = Math.max(ans,recM(v,w,idx+1, cap,dp));
        return dp[cap] = ans;
    }
}