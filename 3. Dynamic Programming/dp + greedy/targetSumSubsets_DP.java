
import java.io.*;
import java.util.*;

public class targetSumSubsets_DP {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] arr = new int[n];
         for(int i=0; i<n; i++){
             arr[i] = in.nextInt();
         }
         int tar = in.nextInt();
         boolean[][] dp = new boolean[n+1][tar + 1];
        //  System.out.println(isTargetM(arr,n, tar, dp));
        System.out.println(isTargetT(arr, n, tar, dp));
        //  boolean[] dp = new boolean[n];
        //  System.out.println(isSum(arr, dp,tar));
        //  System.out.println(isTargetS(arr, arr.length-1, tar));
    }
    
    public static boolean isTargetS(int[] arr, int idx, int tar){
        if(idx == -1 || tar<0){
            if(tar == 0){
                return true;
            }
            return false;
        }
        boolean res = false;
        res = isTargetS(arr, idx-1, tar - arr[idx]);
        if(res) return res;
        return isTargetS(arr, idx-1, tar);
    }
    
    public static boolean isTargetM(int[] arr, int idx, int tar, boolean[][] dp){
        if(idx == 0){
            if(tar == 0){
                return true;
            }
            return false;
        }
        if(dp[idx][tar])  return true;
        boolean res = false;
        if(tar-arr[idx-1] >= 0){
            res = res || isTargetM(arr, idx-1, tar- arr[idx-1], dp);
        }
        res = res || isTargetM(arr, idx-1, tar, dp);
        return dp[idx][tar]= res;
    }
    
    public static boolean isTargetT(int[] arr, int n, int tar, boolean[][] dp){
        for(int idx =0; idx<=n; idx++){
            for(int t = 0; t<=tar; t++){
                if(idx ==0){
                    if(t == 0)
                    dp[idx][t] = true;
                    continue;
                }
                
                    boolean res = false;
                    if(t - arr[idx -1 ] >= 0){
                        res = res || dp[idx-1][t- arr[idx-1]];
                    }
                    res = res || dp[idx-1][t];
                
                dp[idx][t] = res;
                
            }
        }
        return dp[n][tar];
    }
    
    public static boolean isSum(int[] arr, boolean[][] dp, int tar){
        dp[0][0] = true;
        int n = arr.length;
        for(int i=1; i<=n; i++){
            int coins = arr[i-1];
            for(int t = 0; t<=tar; t++){
                
                boolean exc = dp[i-1][t];
                boolean inc = false;
                if(coins <= t){
                    inc = dp[i-1][t - coins];
                }
                dp[i][t] = exc || inc;
            }
        }
        return dp[n][tar];
    }
}