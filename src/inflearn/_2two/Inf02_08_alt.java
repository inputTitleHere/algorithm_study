package inflearn._2two;

import java.util.*;
public class Inf02_08_alt {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] input = new int[n];
		for(int i=0;i<n;i++) {
			input[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			int counter=1;
			for(int j=0;j<n;j++) {
				if (input[i]<input[j]) {
					counter++;
				}
			}
			sb.append(counter);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
