
import java.io.*;
import java.util.*;

public class getKPC {

     public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String str =  in.next();
    System.out.println(getKPC(str));
  }
  public static String[] keypad =  {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
  
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        int idx = str.charAt(0) - '0';
        String word = keypad[idx];
        ArrayList<String> sm = getKPC(str.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            for(String s: sm){
                ans.add(ch+ s);
            }
        }
        return ans;
    }

}
