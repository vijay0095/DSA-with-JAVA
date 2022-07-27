
import java.io.*;
import java.util.*;

public class printSequence {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        printSS(str, "", 0);
    }

    public static void printSS(String str, String ans, int idx) {
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }
        printSS(str, ans + str.charAt(idx), idx+1);
        printSS(str, ans , idx +1);
    }

}