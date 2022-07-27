
import java.io.*;
import java.util.*;

public class printEncodings {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        printEncodings_01(str, 0, "");
        // printEncodings_02(str, 0, "");
    }

    public static char[] alphabets = {'$', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u', 'v' ,'w', 'x', 'y', 'z'};

    public static void printEncodings_01(String str, int idx, String asf){
        if( idx >= str.length()){
            System.out.println(asf);
            return;
        }
        if(str.charAt(idx) == '0'){
            return;
        }
        int aIdx1 = str.charAt(idx) -'0';
        int aIdx2 = 0;

        if(idx+1 < str.length()){
             aIdx2 = aIdx1 * 10 + (str.charAt(idx+1) - '0');
        }        
        char ch1 = alphabets[aIdx1];     
        printEncodings_01(str, idx+1, asf + ch1);
      
        if(aIdx2>9  && aIdx2 <= 26){
            char ch2 = alphabets[aIdx2];
            printEncodings_01(str, idx + 2, asf +ch2);
        }
    }

    public static void printEncodings_02(String str, int idx, String asf){
        if( idx >= str.length()){
            System.out.println(asf);
            return;
        }
        if(str.charAt(idx) == '0'){
            return;
        }
        int val1 = str.charAt(idx) - '0';
        char ch1 = (char)(val1 - 1 + 'a');
        printEncodings_02(str, idx+1, asf + ch1);
        if(idx + 1 < str.length()){
            int val = val1 * 10 + (str.charAt(idx + 1) - '0');
            if(val <= 26){
            char ch2 = (char)(val - 1 +'a');
            printEncodings_02(str, idx +2 , asf + ch2 );
            }
        }

    }


}