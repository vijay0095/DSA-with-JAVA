
// The monuments are named as:
// 1    2    3    4
// 5    6    7    8
// 9   10  11  12
// 13 14  15  16
// The path followed by the visitor is: 1->6->11->16->2->7->12->3->8->4

import java.io.*;
import java.util.*;

public class theStateOfWakanda2 {
    
    public static Scanner in = new Scanner(System.in);
    
    public static void input(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = in.nextInt();
            }
        }
    }
    
    public static void diagonalTraversal(int[][] arr){
        int n = arr.length;
        for(int j=0; j<n; j++){
            int k = 0;
            for(int i=j ; i<n; i++){
                System.out.println(arr[k][i]);
                k++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        input(arr);
        diagonalTraversal(arr);
    }

}