
import java.io.*;
import java.util.*;

public class slidingWindowMaximum{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int[] ans = solve(arr);
    int gi =0;
    for(int i=0; i<= n-k; i++){
        if(gi <i){
            gi = i;
        }
        while(ans[gi] < i+k) gi = ans[gi];
        System.out.println(arr[gi]);
    }
 }
 
 public static int[] solve(int[] arr){
     int n = arr.length;
     int[] ans = new int[n];
     Stack<Integer> st = new Stack<>();
     for(int i=n-1; i>=0 ;i--){
         while(st.size()>0 && arr[st.peek()] <= arr[i]) st.pop();
         
         if(st.size()==0){
             ans[i] = n;
         }else{
             ans[i] = st.peek();
         }
         st.push(i);
     }
     return ans;
 }
}