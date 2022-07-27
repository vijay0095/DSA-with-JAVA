
import java.io.*;
import java.util.*;

public class firstIndex {

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
        int x = in.nextInt();
        System.out.println(firstIndex(arr, 0,x));
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == x){
            return idx;
        }
        int z = firstIndex(arr, idx +1, x);
        return z;
    }

}