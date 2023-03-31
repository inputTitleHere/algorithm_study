package baekjoon.silver.two;

import java.io.IOException;

public class BJ_11055 {
	public static void main(String[] args) throws IOException{
		int n = read();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=read();
		}
		
		int[] dp = new int[n];
		int[] weight = new int[n];
		dp[0]=arr[1];
		int ptr = 1;
		for(int i=1;i<n;i++) {
			int pos = binarysearch(arr[i], ptr, dp);
			
			
		}
		
		
	}

	static int binarysearch(int target, int r, int[] dp) {
		int l = 0;
		while (l < r) {
			int mid = (l + r) / 2;
			if (target <= dp[mid]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}
