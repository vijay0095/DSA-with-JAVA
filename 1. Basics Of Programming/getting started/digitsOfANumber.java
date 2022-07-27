import java.util.*;

public class digitsOfANumber {
    public static void main(String[] args) {
        // write your code here
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int d=0;
            int tmp = n;
            while(tmp !=0){
                d++;
                tmp/=10;
            }
            int pow = (int)Math.pow(10, d-1);
            while(pow!=0){
                System.out.println(n/pow);
                n = n%pow;
                pow/=10;
            }
      }
}
