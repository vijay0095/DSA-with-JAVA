
import java.io.*;
import java.util.*;

public class printKPC {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        printKPC(str, 0, "");
    }

    public static String[] words = {".;" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printKPC(String str, int idx,  String asf){
        if(idx == str.length()){
            System.out.println(asf);
            return;
        }
        int wIdx = (int)(str.charAt(idx) - '0');
        String word = words[wIdx];
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            printKPC(str, idx + 1, asf + ch);
        }
    }

}