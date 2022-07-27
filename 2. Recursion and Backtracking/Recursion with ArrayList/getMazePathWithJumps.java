
import java.io.*;
import java.util.*;

public class getMazePathWithJumps {

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
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
        //horizontal moves;
        for(int j = 1; j<= dc -sc ; j++){
            ArrayList<String> hori = getMazePaths(sr , sc+j,dr, dc);
            for(String h : hori){
                ans.add("h"+j+ h);
            }
        }
        
        //vertical moves;
        for(int j =1 ; j<= dr- sr ; j++){
            ArrayList<String> vert = getMazePaths(sr + j, sc, dr, dc);
            for(String v : vert){
                ans.add("v"+j+ v);
            }
        }
        
        //diagonal moves;
        for(int j=1; j<= dc- sc && j<= dr - sr; j++){
            ArrayList<String> diag = getMazePaths(sr+j, sc+j, dr, dc);
            for(String d: diag){
                ans.add("d"+j+d);
            }
        }
        return ans;
    }



}