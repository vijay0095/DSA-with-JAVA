
import java.io.*;
import java.util.*;

public class ringRotate {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int s = in.nextInt();
        int r= in.nextInt();
        
        rotateShell(arr, s, r);
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void rotateShell(int[][] arr, int s, int r){
        int[] oned = oneD(arr, s);
        rotate(oned, r);
        fillshell(arr,s,oned);
    }
    public static int[] oneD(int[][] arr, int s){
        int rmin = s-1;
        int cmin = s-1;
        int rmax = arr.length -s  ;
        int cmax = arr[0].length -s ;
        int sz = 2*(rmax - rmin + cmax - cmin );
        int[] oned = new int[sz];
        int i=0;
        for(int c = cmin ; c<= cmax; c++){
            oned[i++] = arr[rmin][c];
        }
        for(int r = rmin + 1; r<= rmax; r++){
            oned[i++] = arr[r][cmax];
        }
        for(int c = cmax-1; c>=cmin; c--){
            oned[i++] = arr[rmax][c];
        }
        for(int r = rmax -1; r>rmin; r--){
            oned[i++] = arr[r][cmin];
        }
        return oned;
        
    }
    public static void fillshell(int[][] arr, int s, int[] oned){
        int rmin = s-1;
        int cmin = s-1;
        int rmax = arr.length -s ;
        int cmax = arr[0].length -s;
        // int sz = 2*(rmax - rmin + cmax - cmin );
        // int[] oned = new int[sz];
        int i=0;
        for(int c = cmin ; c<= cmax; c++){
            arr[rmin][c] = oned[i++] ;
        }
        for(int r = rmin + 1; r<= rmax; r++){
             arr[r][cmax] = oned[i++] ;
        }
        for(int c = cmax-1; c>=cmin; c--){
              arr[rmax][c] = oned[i++];
        }
        for(int r = rmax -1; r>rmin; r--){
             arr[r][cmin] = oned[i++] ;
        }
        
    }
    public static void rotate(int[] arr, int r){
        r = r%arr.length;
        if(r<0) r= r+arr.length;
        
        reverse(arr, 0, r-1);
        reverse(arr, r, arr.length-1);reverse(arr, 0, arr.length-1);
        
    }
    public static void reverse(int[] arr, int i, int j){
        while(i<j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

}