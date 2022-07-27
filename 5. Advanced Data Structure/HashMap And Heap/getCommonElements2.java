
import java.io.*;
import java.util.*;

public class getCommonElements2{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int[] a1 = new int[n1];
    for(int i=0; i<n1; i++){
        a1[i] = in.nextInt();
    }
    int n2 = in.nextInt();
    int[] a2 = new int[n2];
    for(int i=0; i<n2; i++){
        a2[i] = in.nextInt();
    }
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0; i<n1; i++){
        hm.put(a1[i], hm.getOrDefault(a1[i],0) + 1);
    }
    for(int i=0; i<n2; i++){
        int k =a2[i];
        if(hm.containsKey(k) && hm.get(k) >0){
            System.out.println(k);
            hm.put(k, hm.get(k) -1);
        }
    }
 }

}