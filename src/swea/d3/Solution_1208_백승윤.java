package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) { // 10회 테케
			int n = Integer.parseInt(br.readLine());
			int[] input = new int[100];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int i = 0;
			while (stk.hasMoreTokens()) {
				input[i++] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(input); // nlogn -> 100개 * 7?
			int lt = 0;
			int rt = 99;
			while (lt < 99 && input[lt + 1] == input[0])
				lt++;
			while (rt > 0 && input[rt - 1] == input[99])
				rt--;

			int preLt = lt;
			int preRt = rt;

			for (i = 0; i < n; i++) { // 이동횟수만큼
				input[0]++; // 처음
				input[99]--;// 끝

				replace(input, 0, lt--);
				replace(input, 99, rt++);
				if (lt == -1) {
					lt = preLt;
					while (lt != 99 && input[lt + 1] == input[0])
						lt++;
				}
				if (rt == 100) {
					rt = preRt;
					while (rt != 0 && input[rt - 1] == input[99])
						rt--;
				}
			}
			// 시도횟수 소진
			sb.append("#").append(t).append(" ").append(input[99] - input[0]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static void replace(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
