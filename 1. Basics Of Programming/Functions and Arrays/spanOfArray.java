
import java.io.*;
import java.util.*;

public class spanOfArray {
    
    public static Scanner in = new Scanner(System.in);
    
    public static void input(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }
    }

  public static void main(String[] args) throws Exception {
    // write your code here
    int n = in.nextInt();
    int[] arr = new int[n];
    input(arr);
    display(arr);
  }
  public static void display(int[] arr){
      int min = arr[0], max = arr[0];
      for(int i=0; i<arr.length; i++){
          if(min>arr[i]){
              min = arr[i];
          }
          if(max< arr[i]){
              max = arr[i];
          }
      }
      System.out.println(max - min);
  }

}