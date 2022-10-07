package inflearn._3three;

import java.util.*;
public class Inf03_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nar = new int[n];
		for(int i=0;i<n;i++) {
			nar[i]=sc.nextInt();
		}
		Arrays.sort(nar);
		int m = sc.nextInt();
		int[] mar = new int[m];
		for(int i=0;i<m;i++) {
			mar[i]=sc.nextInt();
		}
		Arrays.sort(mar);
		// 해결부 - 배열식
		StringBuilder sb= new StringBuilder();
		
		int np=0;
		int mp=0;
		while(np<n&&mp<m) {
			if(nar[np]==mar[mp]) {
				sb.append(nar[np]+" ");
				np++;
				mp++;
			}else if(nar[np]>mar[mp]) {
				mp++;
			}else {
				np++;
			}
		}
		System.out.println(sb.toString());
	}
}
