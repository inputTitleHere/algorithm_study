package inflearn._2two;

import java.util.*;

public class Inf02_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(sc.nextLine());
		String[] A = sc.nextLine().split("\\s");
		String[] B = sc.nextLine().split("\\s");
		for(int i=0;i<n;i++) {
			sb.append(rps(Integer.parseInt(A[i]),Integer.parseInt(B[i])));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static String rps(int a, int b) {
		if(a==b) {
			return "D";
		}
		if(a-b==1||a-b==-2) {
			return "A";
		}else {
			return "B";
		}
	}
}
