
import java.io.*;
import java.util.*;

public class rotateBy90Degree {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }
        rotate(arr);
        display(arr);
    }
    
    public static void rotate(int[][] arr){
        transpose(arr);
        swapCol(arr);
    }
    
    public static void transpose(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                swap2D(arr, i,j,j,i);
            }
        }
    }
    
    public static void swapCol(int[][] arr){
        int n = arr.length;
        int si = 0, ei = arr[0].length -1;
        while(si<ei){
            for(int i=0;  i<n; i++){
                swap2D(arr, i, si, i, ei);
            }
            si++;
            ei--;
        }
        
    }
    
    public static void swap2D(int[][] arr, int i, int j, int k, int l){
        int temp = arr[i][j];
        arr[i][j] = arr[k][l];
        arr[k][l] = temp;
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}