package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14510_User_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			stk = new StringTokenizer(br.readLine());
			int[] trees = new int[n];
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(trees);
			int max = trees[n - 1];
			int[] diffs = new int[n];
			for (int i = 0; i < n; i++) {
				int diff = max - trees[i];
				diffs[i] = diff;
			}
			// 초기 포인터 위치
			int optr = n - 1;
			while (optr > -1 && diffs[optr] == 0) {
				optr--;				
			}
			int eptr = optr - 1;
			while (eptr > -1 && diffs[eptr] == 1) {
				eptr--;				
			}
			
			
			
			int days = 0;
			while (optr > -1) {
				if (optr > -1 && diffs[optr] == 0) { // 0들 앞으로 이동
					while (optr > -1 && diffs[optr] == 0) {
						optr--;
					}
				}
				// 1자라기
				if (optr > -1 && diffs[optr] >= 1) { // 홀수일 지나기
					if (optr == 0 && diffs[optr] == 2) {
						days += 2; // 그냥 보내기
						optr--;
					} else {
						diffs[optr] -= 1;
						days++;
						if (diffs[optr] == 0) {
							while (optr > -1 && diffs[optr] == 0) {
								optr--;
							}							
						}
					}
				}
				// 2자라기 (짝수일 지나기)
				while (eptr > -1 && diffs[eptr] < 2) {
					eptr--;
				}
				if (optr == -1) {
					break;					
				}
				if (eptr < 0) {
					days++; // 그냥 보내기
				} else {
					diffs[eptr] -= 2;
					days++;
				}
			}
			sb.append(days).append("\n");
		}
		System.out.println(sb.toString());
	}
}
