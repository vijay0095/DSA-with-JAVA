
import java.io.*;
import java.util.*;

public class zeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        for(int i=0; i<n; i++){
            v[i] = in.nextInt();
        }
        for(int i=0; i<n; i++){
            w[i] = in.nextInt();
        }
        int cap = in.nextInt();
        // System.out.println(rec(v,w,0,cap));
        int[][] dp = new int[n][cap+1];
        System.out.println(recM(v,w,0,cap,dp));
        // System.out.println(maxValue(v,w,0,cap, dp));
        // System.out.println(maxValueT(v,w,cap, dp));
        // for(int[] arr : dp){
        //     for(int ele : arr){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }
        
    }
    
    public static int rec(int[] v, int[] w, int idx,  int cap){
        if(cap == 0 || idx == v.length) return 0;
        int ans = 0;
        if(cap-w[idx] >= 0){
            ans = Math.max(ans, rec(v,w,idx + 1, cap-w[idx]) + v[idx]);
        }
        ans = Math.max(ans,rec(v,w,idx+1, cap));
        return ans;
    }
    public static int recM(int[] v, int[] w, int idx, int cap, int[][] dp){
        if(cap == 0 || idx == v.length) return 0;
        if(dp[idx][cap] != 0) return dp[idx][cap];
        int ans = 0;
        if(cap-w[idx] >= 0){
            ans = Math.max(ans, recM(v,w,idx + 1, cap-w[idx], dp) + v[idx]);
        }
        ans = Math.max(ans,recM(v,w,idx+1, cap,dp));
        return dp[idx][cap] = ans;
    }
    static int maxValue(int[] v, int[] w, int i, int cap , int[][] dp){
        if(cap == 0) return 0;
        if(i == v.length) return 0;
        if(dp[i][cap]!=0) return dp[i][cap];
        int ans =0;
        if(w[i] <= cap){
            ans = maxValue(v, w,i+1, cap - w[i], dp) + v[i];
        }
        int exc = maxValue(v,w,i+1, cap, dp);
        dp[i][cap] = Math.max(ans, exc);
        return dp[i][cap];
    }
    
    
    
    static int maxValue(int[] v, int[] w, int i, int cap){
        if(cap == 0) return 0;
        if(i == v.length) return 0;
        int ans =0;
        if(w[i]<= cap){
            ans = maxValue(v,w,i+1, cap - w[i]) + v[i];
        }
        int exc = maxValue(v,w,i+1, cap);
        return Math.max(ans, exc);
    }
    
}