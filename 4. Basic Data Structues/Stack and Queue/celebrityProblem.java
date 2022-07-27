
import java.io.*;
import java.util.*;

public class celebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size()>=2){
            int j = st.pop();
            int i = st.pop();
            if(arr[i][j] == 1) st.push(j);
            else{
                st.push(i);
            }
        }
        int pc = st.pop();
        boolean res = true;
        for(int i=0; i<n; i++){
            if(arr[pc][i] == 1){
                res = false;
                break;
            }
            if(i != pc && arr[i][pc] == 0){
                res = false;
                break;
            }
        }
        if(res){
            System.out.println(pc);
        }else{
            System.out.println("none");
        }
    }

}