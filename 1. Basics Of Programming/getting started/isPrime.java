import java.util.*;
  
  public class isPrime{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       int t = scn.nextInt();
       for(int j =1; j<=t ; j++){
           int n = scn.nextInt();
           boolean flag = false;
           for(int i =2; i*i<=n; i++){
               if(n%i== 0){
                   System.out.println("not prime");
                   flag = true;
                   break;
               }
           }
           if(!flag){
                System.out.println("prime");
           }
       }
  
   }
  }