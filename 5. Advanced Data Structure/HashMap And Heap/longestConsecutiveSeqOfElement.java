
import java.io.*;
import java.util.*;

public class longestConsecutiveSeqOfElement{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    HashMap<Integer, Boolean> hm = new HashMap<>();
    for(int i=0; i<n ; i++){
        arr[i] = in.nextInt();
        hm.put(arr[i], true);
    }
    // Set<Integer> st = hm.keySet();
    int st =0;
    int max =0;
    for(Integer start: hm.keySet()){
        if(hm.containsKey(start - 1)) continue;
        
        int size =1;
        Integer e = start + 1;
        while(hm.containsKey(e)){
            e++;
            size++;
        }
        if(max < size || (size == max && st > start)){
            st = start;
            max = size;
        }
        
    }
    for(int i=0; i<max; i++){
        System.out.println(st +i);
    }
 }

}