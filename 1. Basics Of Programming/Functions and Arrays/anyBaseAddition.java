
import java.util.*;
  
public class anyBaseAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int ans =0, pow =1, car =0;
       while(n1!=0 || n2!=0 || car !=0){
           int sum = (n1%10) + (n2%10) + car;
           int dig = sum % b;
           car = sum /b;
           ans+= dig*pow;
           n1/=10;
           n2/=10;
           pow *= 10;
       }
       return ans;
   }
  }