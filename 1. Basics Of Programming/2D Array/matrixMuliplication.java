import java.io.*;
import java.util.*;

public class matrixMuliplication {

  public static Scanner in = new Scanner(System.in);

  public static void input(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = in.nextInt();
      }
    }
  }
  
  public static void multiplyArr(int[][] a, int[][] b){
      int  n = a.length;
      int m = a[0].length;
      int p = b.length;
      int q = b[0].length;
      int[][] res = new int[n][q];
      for(int i=0; i<n; i++){
          for(int j=0; j<q; j++){
              int op = 0;
              for(int k=0; k<m; k++){
                  op += a[i][k] * b[k][j];
              }
            res[i][j] = op; 
          }
      }
      display(res);
  }
  
   public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

  public static void main(String[] args) throws Exception {
    // write your code here
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] arr1 = new int[n][m];
    input(arr1);
    int p = in.nextInt();
    int q = in.nextInt();
    int[][] arr2 = new int[p][q];
    input(arr2);
    if(m==p)
     multiplyArr(arr1, arr2);
    else 
       System.out.println("Invalid input");
  }
  

}