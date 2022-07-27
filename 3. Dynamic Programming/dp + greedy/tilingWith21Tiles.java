
import java.io.*;
import java.util.*;

public class tilingWith21Tiles {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a= 1;
        int b = 2;
        for(int i=3; i<=n+1; i++){
            int c = a+b;
            a=b;
            b=c;
        }
        System.out.println(a);
        // int[] dp = new int[n+1];
        // System.out.println(rec(n,dp));
    }
    
    public static int rec(int n, int[] dp){
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        int a = rec(n-1,dp) + rec(n-2,dp);
        return dp[n]=a;
    }
}