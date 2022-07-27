import java.util.*;
  
public class countDigitOfaNumber {
    public static void main(String[] args) {
        // write your code here  
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d =0;
        while(n!=0){
            d++;
            n=n/10;
        }
        System.out.println(d);
       }
}
