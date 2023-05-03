package baekjoon.gold.five;

import java.io.*;
import java.util.*;

public class BJ_12931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int items = 0;
		int[] tmp = new int[n];
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(stk.nextToken());
			if (next != 0) {
				tmp[items++] = next;
			}
		}
		int[] b = new int[items];
		System.arraycopy(tmp, 0, b, 0, items);

		int move = 0;
		while (true) {
//			System.out.println(move);
//			System.out.println(Arrays.toString(b));
			if (isAllZero(b)) {
				System.out.println(move);
				return;
			}
			for (int i = 0; i < b.length; i++) {
				if (b[i] % 2 == 1) {
					b[i]--;
					move++;
				}
			}
			if (isAllZero(b)) {
				System.out.println(move);
				return;
			}
			for (int i = 0; i < b.length; i++) {
				b[i] /= 2;
			}
			move++;
		}
	}

	static boolean isAllZero(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
