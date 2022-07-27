
import java.io.*;
import java.util.*;

public class exitPointOfAMatrix {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in = new  Scanner(System.in);
        int n =  in.nextInt();
        int m =  in.nextInt();
        int[][] arr = new  int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int r =0, c=0,  d=0;
        while(true){
            d=(d+arr[r][c])%4;
            if(d ==0 ){
                c++;
                if(c==m){
                    System.out.println(r);
                    System.out.println(c-1);
                    break;
                }
            }else if(d == 1){
               r++; 
               if(r==n){
                    System.out.println(r -1);
                    System.out.println(c);
                    break;
                }
            }else if(d==2){
                c--;
                if(c== -1){
                    System.out.println(r);
                    System.out.println(c+1);
                    break;
                }
            }else{
                r--;
                if(r== -1){
                    System.out.println(r +1);
                    System.out.println(c);
                    break;
                }
            }
        }
    }

}