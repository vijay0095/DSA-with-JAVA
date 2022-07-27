
import java.io.*;
import java.util.*;

public class paintFence {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int xx = 0;
        int xy = k;
        for(int i=2; i<=n; i++){
            int nxx = xy;
            int nxy = (xx+xy)*(k-1);
            xx = nxx;
            xy = nxy;
        }
        System.out.println(xy+xx);
    }
}