
import java.io.*;
import java.util.*;

public class getStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> res = new ArrayList<>();
        if(n-1 >= 0){
            ArrayList<String> one = getStairPaths(n-1);
            for(String s: one){
                res.add("1" + s);
            }
        }
        if(n-2 >= 0){
            ArrayList<String> two = getStairPaths(n-2);
            for(String s: two){
                res.add("2" +s);
            }
        }
        if(n-3 >=0){
            ArrayList<String> three = getStairPaths(n-3);
            for(String s: three){
                res.add("3" + s);
            }
        }
        return res;
    }

}