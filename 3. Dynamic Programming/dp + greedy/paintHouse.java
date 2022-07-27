
import java.io.*;
import java.util.*;

public class paintHouse {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int red = arr[0][0];
        int blue = arr[0][1];
        int green = arr[0][2];
        for(int i=1; i<n; i++){
          int nred = arr[i][0] + Math.min(green, blue);
          int nblue = arr[i][1] + Math.min(red, green);
          int ngreen = arr[i][2] + Math.min(red, blue);
          red = nred;
          blue = nblue;
          green = ngreen;
        }
        int ans = Math.min(red, Math.min(blue, green));
        
        System.out.println(ans);
        
    }
}