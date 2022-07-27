
import java.io.*;
import java.util.*;

public class toggleCase {

	public static String toggleCase(String str){
		//write your code here
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++){
		    char c = str.charAt(i);
		    if(c>= 'a' && c<='z'){
		        sb.append((char)( c - 'a' + 'A'));
		    }
		    if(c >= 'A' && c<= 'Z'){
		        sb.append((char)(c - 'A' + 'a'));
		    }
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}