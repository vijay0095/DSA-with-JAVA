
import java.io.*;
import java.util.*;

public class arrayDisplayReverse {
    
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
        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        
        displayArr(arr, idx+1);
        System.out.println(arr[idx]);
    }

}