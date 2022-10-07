package inflearn._2two;

import java.util.*;
public class Inf02_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n+2][n+2];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				m[i][j]=sc.nextInt();
			}
		}
		int counter = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int p = m[i][j];
				if(p>m[i-1][j] && p>m[i+1][j] && p>m[i][j-1] && p>m[i][j+1]){
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}
