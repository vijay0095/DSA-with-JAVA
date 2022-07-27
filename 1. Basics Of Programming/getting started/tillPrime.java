import java.util.*;

public class tillPrime{
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int h = in.nextInt();
        for(int n = l; n<=h; n++){
            boolean flag = true;
            for(int i =2; i*i<=n; i++){
                if(n%i == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println(n);
        }
    }
}