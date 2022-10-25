package inflearn._8eight;

import java.util.*;
public class Inf08_07 {

	// n==r -> 1
	// n >= r 
	// r 0 -> 1
	
	// n = 5 r =3
	// arr[5][3] -> 값을 메모
	
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		arr = new int[n+1][r+1];
		if(r==0) {
			System.out.println(1);
			return;
		}
		System.out.println(memo(n,r));
		
	}
	static int memo(int n, int r) {
		if(n==r) {
			return 1;
		}
		if(r==1) {
			return n;
		}
		if(arr[n-1][r-1]==0) {
			arr[n-1][r-1]=memo(n-1,r-1);
		}
		if(arr[n-1][r]==0) {
			arr[n-1][r]=memo(n-1,r);
		}
		arr[n][r]=arr[n-1][r-1]+arr[n-1][r];
		
		return arr[n][r];
	}	
}

