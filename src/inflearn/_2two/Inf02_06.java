package inflearn._2two;

import java.util.*;
public class Inf02_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] input = sc.nextLine().split("\\s");
		StringBuilder result = new StringBuilder();
		StringBuilder sb;
		for(String s : input) {
			sb = new StringBuilder(s);
			result.append(isPrime(Integer.parseInt(sb.reverse().toString())));
		}
		System.out.println(result.toString());
	}
	public static String isPrime(int n) {
		if(n==1) {
			return "";
		}
		if(n==2 || n==3) {
			return Integer.toString(n)+" ";
		}
		int sqrt = (int)Math.sqrt(n);
		for(int i=2;i<=sqrt;i++) {
			if(n%i==0) {
				return "";
			}
		}
		return Integer.toString(n)+" ";
	}
}
