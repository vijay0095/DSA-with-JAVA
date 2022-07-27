
import java.io.*;
import java.util.*;

public class minCostInMazeTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] cost = new int[n][m];
        for(int i=0; i<n; i++){
             for(int j=0; j<m ;j++){
                  cost[i][j] = in.nextInt();
             }
        }
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        // int ans = minCostR(cost,0,0);
        // int ans = minCostT(cost, dp);
        int ans = minCost(0,0, cost, dp);
        System.out.println(ans);
    }
    
    public static int minCostR(int[][] arr, int sr, int sc){
        if(sr == arr.length-1 && sc==arr[0].length-1) return arr[sr][sc];
        
        int f = Integer.MAX_VALUE;
        if(sr+1<=arr.length-1){
            f = minCostR(arr, sr+1, sc);
        }
        int s= Integer.MAX_VALUE;
        if(sc+1<=arr[0].length-1){
            s = minCostR(arr, sr, sc+1);
        }
        int ans = Math.min(f,s) + arr[sr][sc];
        return ans;
    }
    
    public static int minCostT(int[][] arr, int[][] dp){
        for(int sr = arr.length-1 ; sr>=0; sr--){
            for(int sc = arr[0].length-1; sc>=0; sc--){
                if(sr == arr.length-1 && sc == arr[0].length -1){
                    dp[sr][sc]=  arr[sr][sc];
                    continue;
                }
                
                int first = Integer.MAX_VALUE;
                if(sc + 1 <= arr[0].length -1){
                    first = dp[sr][sc+1];
                }
                int second = Integer.MAX_VALUE;
                if(sr + 1 <= arr.length -1){
                    second = dp[sr+1][sc];
                }
                int ans = Math.min(first, second) + arr[sr][sc];
                dp[sr][sc] = ans;
            }
        }
        return dp[0][0];
    }
    
    public static int minCost(int sr, int sc, int[][] arr,int[][] dp){
        if(sr == arr.length-1 && sc == arr[0].length -1){
            return arr[sr][sc];
        }
        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int first = Integer.MAX_VALUE;
        if(sc + 1 <= arr[0].length -1){
            first = minCost(sr, sc + 1, arr, dp);
        }
        int second = Integer.MAX_VALUE;
        if(sr + 1 <= arr.length -1){
            second = minCost(sr+1, sc, arr, dp);
        }
        int ans = Math.min(first, second) + arr[sr][sc];
        dp[sr][sc] = ans;
        return ans;
    }

}