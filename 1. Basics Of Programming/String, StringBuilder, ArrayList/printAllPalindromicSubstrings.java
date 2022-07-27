import java.io.*;
import java.util.*;

public class printAllPalindromicSubstrings {
    public static boolean isPalindrome(String s)
    {
        String s1="";
        int n=s.length();
        for(int i = n - 1; i >= 0; i--)
        {
            s1 = s1 + s.charAt(i);
        }
        if(s.equals(s1)==true)
        {
            return true;
        }
        else
        return false;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int x=str.length();
        for(int i=0;i<x;i++)
        {
            for(int j=i;j<x;j++)
            {
                if(isPalindrome(str.substring(i,j+1))==true)
                {
                    System.out.println(str.substring(i,j+1));
                }
            }
        }
	}

}