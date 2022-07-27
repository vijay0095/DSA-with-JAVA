import java.util.Scanner;
public class rotateANumber {
    public static void main(String[] args) {
        // write your code here  
           Scanner in = new Scanner(System.in);
           int n= in.nextInt();
           int k = in.nextInt();
           int tmp =n;
           int d =0 ;
           while(tmp != 0){
               tmp /=10;
               d++;
           }
            k = k%d;
            if(k<0) k = k +d;
           int mul = (int)Math.pow(10, d - k);
           int fp = n%(int)Math.pow(10,k) * mul;
           int sp = n/(int)Math.pow(10,k);
           System.out.println(fp+sp);
       }
}
