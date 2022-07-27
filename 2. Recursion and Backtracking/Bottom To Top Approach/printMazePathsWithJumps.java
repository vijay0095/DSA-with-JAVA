
import java.io.*;
import java.util.*;

public class printMazePathsWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        printMazePaths(0, 0, n - 1, m - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        for (int j = 1; sc + j <= dc; j++) {
            printMazePaths(sr, sc + j, dr, dc, psf + "h" + j);
        }
        for (int j = 1; sr + j <= dr; j++) {
            printMazePaths(sr + j, sc, dr, dc, psf + "v" + j);
        }
        for (int j = 1; sr + j <= dr && sc + j <= dc; j++) {
            printMazePaths(sr + j, sc + j, dr, dc, psf + "d" + j);
        }
    }

}