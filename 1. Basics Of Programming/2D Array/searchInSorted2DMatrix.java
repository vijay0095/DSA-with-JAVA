
import java.io.*;
import java.util.*;

public class searchInSorted2DMatrix {
  public static Scanner in = new Scanner(System.in);

  public static void input(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = in.nextInt();
      }
    }
  }
  
  
  public static void findEle(int[][] arr, int ele){
      int r = arr.length -1, c = 0;
      while(r>=0 && c<arr[0].length){
           if(arr[r][c] > ele){
              r--;
          }else if(arr[r][c] < ele){
              c++;
          }else{
              System.out.println(r);
              System.out.println(c);
              return;
          }
      }
      System.out.println("Not Found");
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    int n = in.nextInt();
    int[][] arr = new int[n][n];
    input(arr);
    int ele = in.nextInt();
    findEle(arr,ele);
  }

}