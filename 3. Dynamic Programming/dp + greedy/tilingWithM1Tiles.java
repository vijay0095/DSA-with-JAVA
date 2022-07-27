
import java.io.*;
import java.util.*;

public class tilingWithM1Tiles {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int m = in.nextInt();
         int[] coins = new int[]{1,m};
          int[] dp = new int[n +1];
          dp[0] = 1;
        for(int t = 1; t<=n; t++){
            for(int c = 0; c<2; c++){
                if(coins[c]<= t){
                    int ramt = t - coins[c];
                    dp[t] += dp[ramt]; 
                }
            }
        }
        // for(int ele: dp){
        //     System.out.print(ele+" ");
        // }
        System.out.println(dp[n]);
    }
}