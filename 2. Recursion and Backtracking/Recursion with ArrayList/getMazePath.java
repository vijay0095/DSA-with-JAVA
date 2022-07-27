
import java.io.*;
import java.util.*;

public class getMazePath {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){ 
            ArrayList<String> base = new ArrayList<>();
             base.add("");
             return base;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        if(sc + 1 <= dc){
            ArrayList<String> h = getMazePaths(sr, sc+ 1, dr, dc);
            for(String s: h ){
                ans.add("h" + s);
            }
        }
        if(sr +1 <= dr){
            ArrayList<String> v = getMazePaths(sr +1 , sc, dr, dc);
            for(String s: v){
                ans.add("v" + s);
            }
        }
        return ans;
    }

}