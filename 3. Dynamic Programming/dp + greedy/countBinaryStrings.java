
import java.io.*;
import java.util.*;

public class countBinaryStrings{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a = 1, b=1;
    for(int i=2; i<=n; i++){
        int na = b;
        int nb = a+b;
        a=na;
        b=nb;
    }
    // System.out.println(a+b);
    System.out.println(rec(n,0));
 }
 
 public static int rec(int n, int prv){
     if(n==0) return 0;
     if(n==1){
         if(prv==1) return 1;
         return 2;
     }
     if(prv == 0){
         return rec(n-1, 0) + rec(n-1,1);
     }
     return rec(n-1,0);
 }

}