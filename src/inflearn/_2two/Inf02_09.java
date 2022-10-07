package inflearn._2two;

import java.util.*;
public class Inf02_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		int max=0;
		// 행 & 열 한번에 해도 된다. 
		for(int i=0;i<n;i++) {
			int rsum=0;
			int csum=0;
			for(int j=0;j<n;j++) {
				rsum+=matrix[i][j];
				csum+=matrix[j][i];
			}
			max = Math.max(max, Math.max(rsum, csum));
		}
		// 대각선
		int u=0;
		int d=0;
		for(int k=0;k<n;k++) {
			u+=matrix[k][n-1-k];
			d+=matrix[k][k];
		}
		int b = u>d?u:d;
		max=max>b?max:b;
		System.out.println(max);
	}
}
