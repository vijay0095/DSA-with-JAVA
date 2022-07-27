
import java.io.*;
import java.util.*;

public class maxOfanArray {

    public static Scanner in = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        int n= in.nextInt();
        int[] arr = new int[n];
        input(arr);
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length){
            return Integer.MIN_VALUE;
        }
        int ele = maxOfArray(arr, idx + 1);
        return Math.max(ele, arr[idx]);
    }

}