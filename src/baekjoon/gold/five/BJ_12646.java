package baekjoon.gold.five;

import java.io.*;
import java.util.Arrays;

public class BJ_12646 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= t; tc++) {
			boolean[] contain = new boolean[10];
			addCaseNo(sb, tc);
			char[] input = br.readLine().toCharArray();
			int[] number = new int[input.length];
			int ptr = 0;
			for (char c : input) {
				int cn = c - '0';
				contain[cn] = true;
				number[ptr++] = cn;
			}
			int l, r = l = input.length - 1;
			// nextpermutation처럼
			while (l > 0 && number[l - 1] >= number[l])
				l--;
			if (l > 0) {
				int j = r;
				while(number[l-1]>=number[j]) {
					j--;
				}
				swap(l-1,j,number);
			} else { // 자릿수 추가.
				for (int i = 1; i < 10; i++) {
					if (contain[i]) {
						int[] extNumber = new int[number.length + 1];
						int zero = 0;
						for (int z : number) {
							if (z == 0) {
								zero++;
							}
						}
						System.arraycopy(number, 0, extNumber, 2 + zero, number.length - 1 - zero);
						extNumber[0] = i;
						extNumber[1] = 0;
						number = extNumber;
//						System.out.println("zero = " + zero);
						l += zero+2; // 시작점 + 추가 0
						r++;
						break;
					}
				}
			}
			
			
			// 0개수 밀기
			while (l < r) {
				swap(l++, r--, number);
			}
			for (int i : number) {
				sb.append(i);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void addCaseNo(StringBuilder sb, int no) {
		sb.append("Case #").append(no).append(": ");
	}

	static void swap(int l, int r, int[] arr) {
		int t = arr[l];
		arr[l] = arr[r];
		arr[r] = t;
	}
}
