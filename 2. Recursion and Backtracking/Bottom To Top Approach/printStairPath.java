
import java.io.*;
import java.util.*;

public class printStairPath {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }
        for (int j = 1; j <= 3 && n - j >= 0; j++) {
            printStairPaths(n - j, path + j);
        }
    }

}