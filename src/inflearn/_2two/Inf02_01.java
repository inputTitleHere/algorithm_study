package inflearn._2two;

import java.util.*;

public class Inf02_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(sc.nextLine());
		int curr = 0;
		String[] inputs = sc.nextLine().split("\\s");
		for(String s : inputs) {
			int in = Integer.parseInt(s);
			if(in>curr) {
				sb.append(in);
				sb.append(" ");
			}
			curr=in;
		}
		System.out.println(sb.toString().trim());
	}
}
