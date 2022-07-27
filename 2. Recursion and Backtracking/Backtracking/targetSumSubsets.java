
import java.io.*;
import java.util.*;

public class targetSumSubsets {
    public static Scanner in = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        int n = in.nextInt();
        int[] arr = new int[n];
        input(arr);
        int tar = in.nextInt();
        printTargetSumSubsets(arr, 0, "", tar);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String sos, int tar) {
        if(idx == arr.length || tar < 0){
            if(tar == 0)
             System.out.println(sos +".");
            return;
        }
        printTargetSumSubsets(arr, idx +1, sos + arr[idx] +", ", tar - arr[idx]);
        printTargetSumSubsets(arr, idx +1, sos, tar);
    }

}