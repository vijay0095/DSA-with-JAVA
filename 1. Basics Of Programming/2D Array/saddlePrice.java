
import java.io.*;
import java.util.*;

public class saddlePrice {
  public static Scanner in = new Scanner(System.in);

  public static void input(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = in.nextInt();
      }
    }
  }
  
  public static void saddlePrice_(int[][] arr){
      int n = arr.length;
      for(int i=0; i<n; i++){
          int min = (int)1e9;
          int c = 0;
          for(int j=0; j<n; j++){
              if(min>=arr[i][j]){
                  min = arr[i][j];
                  c =  j;
              }
          }
          int max = -(int)1e9;
          for(int j=0; j<n; j++){
              if(max<= arr[j][c]){
                  max =  arr[j][c];
              }
          }
          if(min == max){
              System.out.println(max);
              return;
          }
      }
      System.out.println("Invalid input");
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    int n = in.nextInt();
    int[][] arr = new  int[n][n];
    input(arr);
    saddlePrice_(arr);
  }

}