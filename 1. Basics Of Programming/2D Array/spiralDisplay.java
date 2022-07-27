
import java.io.*;
import java.util.*;

public class spiralDisplay {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), m = in.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m ; j++) {
        arr[i][j] = in.nextInt();
      }
    }
    int count  = n*m;
    int cmin =0, cmax = m-1, rmin =0, rmax =n-1;
    while(count>0){
        for(int r = rmin; r<= rmax && count >0; r++){
            System.out.println(arr[r][cmin]);
            count--;
        }
        cmin++;
        for(int c = cmin; c<=cmax && count>0 ; c++){
            System.out.println(arr[rmax][c]);
            count--;
        }
        rmax--;
        for(int r = rmax ;   r>=rmin && count>0 ;  r--){
            System.out.println(arr[r][cmax]);
            count--;
        }
        cmax--;
        for(int c = cmax; c>= cmin && count>0 ; c--){
            System.out.println(arr[rmin][c]);
            count--;
        }
        rmin++;
    }
  }

}