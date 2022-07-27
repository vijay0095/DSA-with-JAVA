
import java.io.*;
import java.util.*;

public class climbStairsWithVariableJumps {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = varJumpM(0, n, arr, dp);
        System.out.println(ans);
    }
    public static int varJump(int i, int n , int[] jumps){
        if(i == n) return 1;
        int count =0;
        for(int jump = 1; jump<= jumps[i] && jump + i <= n; jump++){
            count += varJump(i+jump, n, jumps);
        }
        return count;
    }
    
    public static int varJumpM(int i, int n, int[] jumps, int[] dp){
        if(i == n) return 1;
        if(dp[i]!=-1) return dp[i];
        int count =0;
        for(int jump = 1; jump<= jumps[i] && jump + i <= n; jump++){
            count += varJumpM(i+jump, n, jumps, dp);
        }
        dp[i]  = count;
        return count;
    }
}