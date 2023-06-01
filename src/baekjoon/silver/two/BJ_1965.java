package baekjoon.silver.two;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] dp = new int[n];
		int len=0;
		
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(stk.nextToken());
			int index = binSearch(next, dp, len);
			if(index==-1) {
				dp[len++]=next;
			}else {
				dp[index]=next;
			}
		}
		System.out.println(len);
	}

	private static int binSearch(int target, int[] arr, int limit) {
		int res = 0;
		int left = 0;
		int right = limit;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target <= arr[mid]) {
				res = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (left == limit+1) {
			return -1; // 못찾음
		} else {
			return res;
		}

	}
}
