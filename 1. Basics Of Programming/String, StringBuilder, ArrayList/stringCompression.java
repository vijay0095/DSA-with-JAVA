
import java.io.*;
import java.util.*;

public class stringCompression {

	public static String compression1(String str){
		// write your code here
        StringBuilder sb = new  StringBuilder();
        int i =1, n= str.length();
        sb.append(str.charAt(0));
        while(i<n){
            while(i<n && str.charAt(i) == sb.charAt(sb.length()-1)){
                i++;
            }
            if(i<n)
            sb.append(str.charAt(i));
        
        }
		return sb.toString();
	}

	public static String compression2(String str){
		// write your code here
		StringBuilder sb = new  StringBuilder();
        char pc = str.charAt(0);
        int c=1;
        sb.append(str.charAt(0));
        for(int i=1; i<str.length();  i++){
            char ch = str.charAt(i);
            if(ch!=pc){
                if(c!=1)
                sb.append(c);
                sb.append(ch);
                pc = ch;
                c=1;
            }else{
                c++;
            }
        }
        if(c!=1)
        sb.append(c);
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}