
import java.io.*;
import java.util.*;

public class climbStairsWithMinimumMoves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int[] dp = new int[n+1];
        int ans = minJ(0,n,arr);
        // for(int ele : dp){
        //     System.out.print(ele+" ");
        // }
        // System.out.println();
        if(ans < 30 ){
            System.out.println(ans);
        }else{
            System.out.println("null");
        }
    }
    
    public static int minJ(int i, int n, int[] jumps){
        if(i==n) return 0;
        int min = 30;
        for(int j = 1; j<=jumps[i] && i+j <=n; j++){
            int faith = minJ(i+j, n, jumps)+1;
            min = Math.min(min, faith);
        }
        return min;
    }
    public static int minJump(int i, int N, int[] jumps, int[] dp){
        for(i=N; i>=0; i--){
            if(i==N){
                dp[i] = 0;
                continue;
            }
            int min = 30;
            for(int jump = 1; jump<=jumps[i] && i+ jump <= N; jump++){
                int faith = dp[i+jump] +1;
                min = Math.min(min, faith);
            }
            dp[i] = min;
        }
        return dp[0];
    }

}