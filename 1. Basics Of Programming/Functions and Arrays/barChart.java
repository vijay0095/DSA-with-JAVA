
import java.io.*;
import java.util.*;

public class barChart{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner in = new Scanner(System.in);
    int n= in.nextInt();
    int[] arr = new int[n];
    int max =  0;
    for(int i =0; i<n; i++){
        arr[i] = in.nextInt();
        if(max < arr[i]){
            max = arr[i];
        }
    }
    int n1 = max;
    for(int i=0; i<n1 ; i++){
        for(int j=0; j<n; j++){
            if(max == arr[j]){
                System.out.print("*	");
                arr[j] = arr[j]- 1;
            }else{
                System.out.print("	");
            }
           
        }
         max--;
        System.out.println();
    }
    
 }

}