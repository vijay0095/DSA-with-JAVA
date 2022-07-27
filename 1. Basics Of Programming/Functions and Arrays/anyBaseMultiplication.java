
import java.util.*;

public class anyBaseMultiplication{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }

 public static int getProduct(int b, int n1, int n2){
     // write your code here
     int ans =0, pow = 1;
     while(n2!=0){
         int r = n2%10;
         n2/=10;
         int val = gpwd(b, n1, r);
         ans = getSum(b, ans, val * pow);
         pow *= 10;
     }
     return ans;
 }
 
 public static int gpwd(int b, int n, int d){
     int ans =0, pow =1, car =0;
     while(n!=0 || car != 0){
         int r1 = n%10;
         int op = r1 * d +car;
         int q = op / b;
         int r = op % b;
         ans += r * pow;
         car = q;
         pow*=10;
         n/=10;
     }
     return ans;
 }
 public static int getSum(int b, int n1, int n2){
     int ans =0, pow =1, car =0;
     while(n1!=0 || n2!=0 || car !=0){
         int r1 = n1%10;
         int r2 = n2%10;
         n1 /= 10;
         n2 /= 10;
         int sum = r1 + r2 + car;
         int q = sum / b;
         int r = sum %b;
         ans += r*pow;
         car = q;
          pow *= 10;
     }
     return ans;
 }
 

}