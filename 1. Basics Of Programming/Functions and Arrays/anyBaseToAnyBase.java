
import java.util.*;
  
  public class anyBaseToAnyBase{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int inDecimal = anyToDecimal(n , sourceBase);
     int indesBase = decimalToAny(inDecimal, destBase);
     System.out.println(indesBase);
   }   
   public static int anyToDecimal(int n , int b){
       int ans =0, pow = 1;
       while(n!=0){
           int r = n%10;
           ans += r*pow;
           pow*=b;
           n/=10;
       }
       return ans;
   }
   public static int decimalToAny(int n , int  b){
       int ans  =0, pow  = 1;
       while(n!=0){
           int r = n%b;
           ans += r*pow;
           pow*=10;
           n/=b;
       }
       return ans;
   }
  }