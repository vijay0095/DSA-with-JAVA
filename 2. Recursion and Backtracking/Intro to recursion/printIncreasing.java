
import java.io.*;
import java.util.*;

public class printIncreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printIncreasing_(n);
    }

    public static void printIncreasing_(int n){
        if(n==0){
            return;
        }
        printIncreasing_(n-1);
        System.out.println(n);
    }

}