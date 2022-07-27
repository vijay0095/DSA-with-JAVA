
import java.io.*;
import java.util.*;

public class floodFill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] vis = new boolean[n][m];
        floodFill(arr, 0, 0,vis, "");
    }
    
    // asf -> answer so far
    public static void floodFill(int[][] arr, int sr, int sc, boolean[][] vis, String asf){
        if(sr < 0 || sr >= arr.length || sc >= arr[0].length || sc <0 || vis[sr][sc] == true || arr[sr][sc] == 1){
             return;
        }
        if(sr == arr.length - 1 && sc == arr[0].length - 1){
            System.out.println(asf);
            return;
        }
        vis[sr][sc] = true;
        floodFill(arr, sr -1 , sc , vis , asf +"t");
        floodFill(arr, sr, sc - 1, vis , asf +"l");
        floodFill(arr, sr + 1, sc , vis, asf + "d");
        floodFill(arr, sr , sc+1, vis, asf + "r");
        vis[sr][sc] = false;
    }
}