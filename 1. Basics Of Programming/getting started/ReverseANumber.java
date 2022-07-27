import java.util.*;
   
public class ReverseANumber {
    public static void main(String[] args) {
        // write your code here  
               Scanner in = new Scanner(System.in);
               int n = in.nextInt();
               while(n!=0){
                   int r = n%10;
                  System.out.println(r);
                   n/=10;
               }
               
       }
}
