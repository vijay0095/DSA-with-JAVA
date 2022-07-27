
import java.io.*;
import java.util.*;

public class stringWithDifferenceOfEveryTwoConsecutiveCharacters {

	public static String solution(String str){
		// write your code here
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		char pc = str.charAt(0);
		for(int i=1; i<str.length(); i++){
		    char nc = str.charAt(i);
		    sb.append(nc - pc);
		    sb.append(nc);
		    pc = nc;
		}
// 		sb.append(str.charAt(str.length()-1));

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}