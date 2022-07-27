// The route of the monument is fixed and expressed in a 2-d matrix where the travelers visit the prescribed next monument. For example

// 1  2  3
// 4  5  6
// 7  8  9

// is the prescribed route and the visitors travels this path: 1->2->3->4->5->6->7->8->9

import java.io.*;
import java.util.*;

public class theStateOfWakanda_1{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), m= in.nextInt();
    int[][] arr = new int[n][m];
    for(int i=0; i<n; i++){
        for(int j =0; j<m ;j++){
           arr[i][j] = in.nextInt();
        }
        
    }
    for(int j=0; j<m; j++){
        if(j%2==0){
            for(int i=0; i<n; i++){
                System.out.println(arr[i][j]);
            }
        }else{
            for(int i=n-1; i>=0; i--){
                System.out.println(arr[i][j]);
            }
        }
    }
    
 }

}
