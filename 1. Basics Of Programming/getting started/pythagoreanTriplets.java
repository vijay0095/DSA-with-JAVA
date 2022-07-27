import java.util.*;
  
public class pythagoreanTriplets{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int max = a;
    if(max<= b){
        max = b;
    }
    if(max<= c){
        max = c;
    }
    if(max == a){
        boolean flag = ((b*b + c*c) == a*a);
        System.out.println(flag);
        
    }else if(max == b){
        boolean flag = ((a*a + c*c) == b*b);
        System.out.println(flag);
    }else{
        boolean flag = ((a*a +b*b) == c*c);
        System.out.println(flag);
    }
   }
  }