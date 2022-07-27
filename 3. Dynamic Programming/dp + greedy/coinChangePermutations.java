

import java.io.*;
import java.util.*;

public class coinChangePermutations {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] coins = new int[n];
          for(int i=0; i<n; i++){
              coins[i] = in.nextInt();
          }
          int tar = in.nextInt();
          int[] dp = new int[tar+1];
          Arrays.fill(dp,-1);
          System.out.println(recM(coins, tar, dp));
        //   int[] dp = new int[tar +1];
        //   dp[0] = 1;
        // for(int t = 1; t<=tar; t++){
        //     for(int c = 0; c<n; c++){
        //         if(coins[c]<= t){
        //             int ramt = t - coins[c];
        //             dp[t] += dp[ramt]; 
        //         }
        //     }
        // }
        // // for(int ele: dp){
        // //     System.out.print(ele+" ");
        // // }
        // System.out.println(dp[tar]);
    }
    public static int recM(int[] arr, int amt, int[] dp){
        if(amt == 0) return 1;
        if(dp[amt] != -1) return dp[amt];
        int ans =0;
        for(int i=0; i<arr.length; i++){
            if(amt - arr[i]>=0)
                ans+=recM(arr, amt-arr[i], dp);
        }
        return dp[amt]=ans;
    }
    public static int rec(int[] arr, int amt, int idx){
        if(amt == 0) return 1;
        if(idx == arr.length) return 0;
        int ans =0;
        for(int i=idx; i<arr.length; i++){
            if(amt - arr[i]>=0)
                ans+=rec(arr, amt-arr[i],0);
        }
        return ans;
    }
    
    
}