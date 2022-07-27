
import java.io.*;
import java.util.*;

public class highestFreqCharacter {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        int max =0;
        char ans = ' ';
        for(Character c : hm.keySet()){
            int v = hm.get(c);
            if(max < v){
                max = v;
                ans = c;
            }
        }
        System.out.println(ans);
    }

}