
import java.io.*;
import java.util.*;

public class largestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] r = rightSmallest(a);
    int[] l = leftSmallest(a);
    int maxArea =0;
    for(int i=0;i<n;i++){
        int width = r[i] - l[i] -1; 
        maxArea= Math.max(maxArea, width*a[i]);
    }
    System.out.println(maxArea);
 }

 public static int[] rightSmallest(int[] arr){
   // solve
   int n = arr.length;
   int[] ans = new int[n];
   Stack<Integer> st = new Stack<>();
   Arrays.fill(ans, n);
   for(int i= 0; i<n; i++){
       while(st.size()>0 && arr[i] < arr[st.peek()] ){
           ans[st.pop()] = i;
       }
        
        st.push(i);
   }
   return ans;
 }
 public static int[] leftSmallest(int[] arr){
   // solve
   int n = arr.length;
   int[] ans = new int[n];
   Stack<Integer> st = new Stack<>();
   Arrays.fill(ans, -1);
   for(int i= n-1; i>=0; i--){
       while(st.size()>0 && arr[i] < arr[st.peek()]){
           ans[st.pop()] = i;
       }
        
        st.push(i);
   }
   return ans;
 }

}