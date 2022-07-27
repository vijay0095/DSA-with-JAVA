import java.util.*;
  
public class anyBaseSubtraction{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int ans =0, pow =1, br=0;
       while(n1!=0 || n2!=0){
           int r1 = n1%10;
           int r2 = n2%10;
           int dif = r2 -r1 +br;
           if(dif<0){
               dif+=b;
               br =-1;
           }else{
               br =0;
           }
           ans += dif *pow;
           n1 /=10;
           n2/=10;
           pow *=10;
       }
       return ans;
   }
  
  }