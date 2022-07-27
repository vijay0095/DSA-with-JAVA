
import java.io.*;
import java.util.*;

public class countEncodings {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        int[] dp = new int[n];
        System.out.println(print(s,s.length()-1));
    }
    public static int endcode(String str, int[] dp){
        for(int n=0; n<str.length(); n++){
            if(n==0){
             dp[n] = 1;
             continue;
        }else if(str.charAt(n-1) == '0' && str.charAt(n) == '0'){
            dp[n] = 0;
            return 0;
        }else if(str.charAt(n-1) == '0' && str.charAt(n) != '0'){
            dp[n] = dp[n-1];
            continue;
           
        }else if(str.charAt(n-1) != '0' && str.charAt(n) == '0'){
            if(str.charAt(n-1) == '1' || str.charAt(n-1) == '2'){
               if(n-2>=0){
                   dp[n] = dp[n-2];
                   continue;               }
               dp[n] = 1;
               continue;
            }
            dp[n] = 0;
            continue;
        }else{
            int num = Integer.parseInt(str.substring(n-1, n+1));
            if(num <= 26){
                if(n-2>=0){
                    dp[n] = dp[n-1] +dp[n-2];
                    continue;
                }else{
                    dp[n] = dp[n-1] +1;
                    continue;
                }
            }else{
                dp[n] = dp[n-1];
                continue;
               }
        }
        }
        return dp[str.length()-1];
    }
    public static int print(String str, int n){
        if(n==0){
            if(str.charAt(n) == '0') return 0;
            return 1;
        }else if(str.charAt(n-1) == '0' && str.charAt(n) == '0'){
            return 0;
        }else if(str.charAt(n-1) == '0' && str.charAt(n) != '0'){
            return print(str, n-1);
        }else if(str.charAt(n-1) != '0' && str.charAt(n) == '0'){
            if(str.charAt(n-1) == '1' || str.charAt(n-1) == '2'){
               if(n-2>=0){
                   return print(str, n-2);
               }
                return 1;
            }
            return 0;
        }else{
            int num = Integer.parseInt(str.substring(n-1, n+1));
            if(num <= 26){
                if(n-2>=0){
                    return print(str, n-1) + print(str, n-2);
                }else{
                    return print(str, n-1) +1;
                }
            }else{
                return print(str, n-1);
            }
        }
        
    }
}