
import java.io.*;
import java.util.*;

public class arrangeBuildings {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int qb[][] =new int[n+1][2];
    // int qb1[]=new int[n+1];
    
    qb[1][0]=qb[1][1]=1;
    
    for(int i=2;i<=n;i++)
    {
        qb[i][0]=qb[i-1][1];
        qb[i][1]=qb[i-1][0]+qb[i-1][1];
    }
    
    long total = qb[n][0]+qb[n][1];
    System.out.println(total * total);
  }
}