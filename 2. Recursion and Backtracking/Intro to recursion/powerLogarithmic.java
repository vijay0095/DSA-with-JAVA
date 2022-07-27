
import java.io.*;
import java.util.*;

public class powerLogarithmic {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new  Scanner(System.in);
        int x = in.nextInt();
        int n = in.nextInt();
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n<=0){
            return 1;
        }
        int smallAns = power(x, n/2);
        smallAns *= smallAns;
        return (n%2 == 0) ? smallAns : (smallAns * x);
    }

}