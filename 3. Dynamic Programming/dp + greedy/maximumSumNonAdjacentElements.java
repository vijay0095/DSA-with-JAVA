
import java.io.*;
import java.util.*;

public class maximumSumNonAdjacentElements {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int inc = 0;
        int exc = 0;
        for(int i=0; i<n; i++){
            int nexc = Math.max(inc, exc);
            int ninc = exc + arr[i];
            inc = ninc;
            exc = nexc;
        }
        // System.out.println(Math.max(inc, exc));
        int[] dp = new int[n+1];
        System.out.println(rec(arr, n, dp));
        // System.out.println(rec(arr, 0, 0));
    }
    public static int rec(int[] arr, int idx, int sum){
        if(idx >= arr.length) return sum;
        // int ans = 0;
        int inc = rec(arr, idx+2, sum+arr[idx]);
        int exc = Math.max(rec(arr, idx +1, sum),inc);
        int ans = Math.max(inc, exc);
        return ans;
        
    }
    public static int rec(int[] arr, int idx, int[] dp){
        if(idx<=0) return 0;
        if(dp[idx] != 0) return dp[idx];
        
        int inc = arr[idx-1] + rec(arr, idx-2,dp);
        int exc = rec(arr, idx-1, dp);
        return dp[idx] = Math.max(inc, exc);
    }
}