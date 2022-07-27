
import java.io.*;
import java.util.*;

public class towerOfHanoi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in  = new Scanner(System.in);
        int n =  in.nextInt();
        int a = in.nextInt();
         int b = in.nextInt();
         int c = in.nextInt();
         toh(n,a,b,c);
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n==0){
            //  System.out.println(n+"["+t1id+" -> "+ t2id +"]");
             return;
        }
        toh(n -1 , t1id, t3id, t2id);
        System.out.println(n+"["+t1id+" -> "+ t2id +"]");
        toh(n-1, t3id, t2id, t1id);
    }

}