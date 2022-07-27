
import java.io.*;
import java.util.*;

public class goldmine {

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
         
         int ans =0;
         for(int r=0; r<n; r++){
             int ans2 = goldMine( cost,r,0, n-1, m-1, dp);
            // int ans2 = goldMineR(cost, r, 0, n-1, m-1);
             ans = Math.max(ans, ans2);
         }
        //  for(int[] arr: dp){
        //      for(int ele : arr){
        //          System.out.print(ele+" ");
        //      }
        //      System.out.println();
        //  }
        System.out.println(goldMineT(cost, n-1, m-1,dp));
        // System.out.println(ans);
    }
    
    public static int goldMineT(int[][] cost ,int dr, int dc, int[][] dp){
        
        for(int c = dc; c>=0; c--){
            for(int r=dr ; r>=0; r--){
                if(c == dc){
                    dp[r][c] = cost[r][c];
                    continue;
                }
                int max =0;
                if(r-1>=0 && c+1 <=dc){
                    max = Math.max(max, dp[r-1][c+1]);
                }
                if(c+1 <=dc){
                    max = Math.max(max, dp[r][c+1]);
                }
                if(r+1 <=dr && c+1 <= dc){
                    max = Math.max(max, dp[r+1][c+1]);
                }
                dp[r][c] = max+ cost[r][c];
            }
        }
        int ans = 0;
        for(int r =0; r<=dr; r++){
            ans = Math.max(ans, dp[r][0]);
        }
       return ans;
    }
    
    public static int goldMineR(int[][] cost, int sr, int sc, int dr, int dc){
        if(sc ==dc){
            return cost[sr][sc];
        }
        int d1 =0, d2=0, r=0;
        if(sr-1>=0 && sc+1 <=dc){
            d1 = goldMineR(cost, sr-1, sc+1, dr, dc);
        }
        if(sc+1 <= dc){
            r = goldMineR(cost, sr, sc+1, dr, dc);
        }
        if(sr+1 <= dr && sc+1 <=dc){
            d2 = goldMineR(cost, sr+1, sc+1, dr, dc);
        }
        int ans = Math.max(d1, Math.max(r,d2)) + cost[sr][sc];
        return ans;
    }
    
    static int goldMine(int[][] cost,int sr, int sc, int dr, int dc , int[][] dp){
        if(sc == dc){
            return cost[sr][sc];
        }
        if(dp[sr][sc] != -1) return dp[sr][sc];
        int d1 = 0, d2 = 0, r = 0;
        if(sr-1>=0 && sc + 1 <= dc){
             d1 = goldMine(cost, sr-1, sc+1, dr, dc,dp);
        }
        if(sc + 1 <= dc){
            r = goldMine(cost, sr, sc+1, dr, dc,dp);
        }
        if(sr + 1 <= dr && sc + 1<= dc){
            d2 = goldMine(cost, sr+1, sc+1, dr, dc,dp);
        }
        int ans = Math.max(Math.max(d1, r), d2) + cost[sr][sc];
        dp[sr][sc] = ans;
        return ans;
    }
    
        
    

}