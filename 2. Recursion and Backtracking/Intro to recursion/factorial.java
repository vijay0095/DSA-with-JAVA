
import java.io.*;
import java.util.*;

public class factorial {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        int smallAns = factorial(n-1);
        
        return n*smallAns;
    }

}