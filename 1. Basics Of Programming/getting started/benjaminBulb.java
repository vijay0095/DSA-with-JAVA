import java.util.Scanner;
public class benjaminBulb {
    public static void main(String[] args) {
        // write your code here 
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1; i*i<=n; i++){
            System.out.println(i*i);
        }
       }
}
