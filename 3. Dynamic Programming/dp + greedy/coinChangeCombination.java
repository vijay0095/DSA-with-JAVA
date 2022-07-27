
import java.io.*;
import java.util.*;

public class coinChangeCombination {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int amt = in.nextInt();
        int[][] dp = new int[n][amt+1];
        System.out.println(recM(arr,amt,0,dp));
        // int[] dp = new int[amt + 1];
        // System.out.println(coinChangeM(arr, 0, amt, dp));
    }
    
    public static int rec(int[] arr, int amt, int idx){
        if(amt == 0) return 1;
        if(idx == arr.length) return 0;
        int ans =0;
        for(int i=idx; i<arr.length; i++){
            if(amt - arr[i]>=0)
                ans+=rec(arr, amt-arr[i],i);
        }
        return ans;
    }
    public static int recM(int[] arr, int amt, int idx, int[][] dp){
        if(amt == 0) return 1;
        if(idx == arr.length) return 0;
        if(dp[idx][amt] != 0) return dp[idx][amt];
        int ans =0;
        for(int i=idx; i<arr.length; i++){
            if(amt - arr[i]>=0)
                ans+=recM(arr, amt-arr[i],i,dp);
        }
        return dp[idx][amt] = ans;
    }
    
    static int coinChange(int[] arr, int idx , int tar){
        if(tar== 0) return 1;
        if(idx == arr.length) return 0;
        int ans =0;
        for(int r = 0; arr[idx] * r <= tar; r++){
            ans += coinChange(arr, idx +1, tar - arr[idx]*r);
        }
        return ans;
    }
    
    static int coinChangeM(int[] arr, int idx , int tar, int[] dp){
        if(tar== 0) return 1;
        if(idx == arr.length) return 0;
        if(dp[tar]!=0) return dp[tar];
        int ans =0;
        for(int r = 0; arr[idx] * r <= tar; r++){
            ans += coinChange(arr, idx +1, tar - arr[idx]*r);
            dp[tar - arr[idx]*r] = ans;
        }
        return ans;
    }
}