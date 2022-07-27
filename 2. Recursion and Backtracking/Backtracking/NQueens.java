
import java.io.*;
import java.util.*;

public class NQueens {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        boolean[][] chess = new boolean[n][n];
        Nqueen(chess, "", 0);
    }

    public static void Nqueen(boolean[][] chess, String asf, int r){
        if(r == chess.length){
            System.out.println(asf +".");
            return;
        }
        for(int j = 0 ; j<chess[0].length ; j++){
            if(isQueenSafe(chess, r,j)){
                chess[r][j] = true;
                Nqueen(chess, asf + r +"-" + j +", ", r + 1);
                chess[r][j] = false;
            }
        }
    }

    public static boolean isQueenSafe(boolean[][] chess, int r , int c){
        //col no 
        for(int i = 0; i<r ; i++){
            if(chess[i][c] == true){
                return false;
            }
        }
        // check d1
        for(int i =1 ; r - i >=0 && c + i < chess[0].length; i++){
            if(chess[r -i][c+i]){
                 return false;
            }
        }
        // check d2
        for(int i=1; r-i >= 0 && c-i >=0; i++){
            if(chess[r - i][ c -i]){
                 return false;
            }
        }
        return true;
    }
    
}