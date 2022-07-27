
import java.io.*;
import java.util.*;

public class getSubsequence {

    public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
     String str = in.next();
     System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        ArrayList<String> smallans = gss(ss);
        ArrayList<String> ans =  new ArrayList<>(smallans);
        for(String s : smallans){
            ans.add(ch + s);
        }
        return ans;
    }

}