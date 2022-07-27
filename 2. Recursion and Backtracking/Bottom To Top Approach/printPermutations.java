
import java.io.*;
import java.util.*;

public class printPermutations {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        printPermutations_(str, "");
    }

    public static void printPermutations_(String str, String asf){
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String ss = str.substring(0, i) + str.substring(i+1);
            printPermutations_(ss, asf +ch);
        }
    }

}