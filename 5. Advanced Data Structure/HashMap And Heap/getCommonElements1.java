
import java.io.*;
import java.util.*;

public class getCommonElements1{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int[] ar1 = new int[n1];
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0; i<n1; i++){
        ar1[i] = in.nextInt();
        hm.put(ar1[i], hm.getOrDefault(ar1[i],0)+1);
    }
    int n2 = in.nextInt();
    int[] ar2 = new int[n2];
    for(int i=0; i<n2; i++){
        ar2[i] = in.nextInt();
    }
    for(int i=0; i<n2; i++){
        int v = ar2[i];
        if(hm.containsKey(v)){
            System.out.println(v);
            hm.remove(v);
        }
    }
 }

}