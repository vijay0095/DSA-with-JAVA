
import java.io.*;
import java.util.*;

public class printDecreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printDecreasing_(n);
    }

    public static void printDecreasing_(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing_(n-1);
    }

}