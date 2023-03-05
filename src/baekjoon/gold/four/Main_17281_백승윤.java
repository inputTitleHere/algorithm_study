package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_백승윤 {

	static int n;
	static int maxPoint = 0;
	static int[][] performance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine()); // 이닝
		performance = new int[n][10];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				performance[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 1번타자는 무조건 4번.
		int[] order = { 2, 3, 4, 5, 6, 7, 8, 9 }; // 1번타자는 4번자리
		while (nextPermutation(order)) {
			int[] tmp = new int[9];
			System.arraycopy(order, 0, tmp, 0, 3);
			tmp[3] = 1;
			System.arraycopy(order, 3, tmp, 4, 5);
			simulate(tmp);
		}

		System.out.println(maxPoint);
	}

	static boolean nextPermutation(int[] order) { // 1을 제외한 8칸짜리임
		// next permutation으로 해야할 듯
		// 전략 : 1을 제외한 2~9를 np한 다음에 4번자리에 1을 끼워두기.
		int l = 7; // 끝
		while (l > 0 && order[l - 1] >= order[l])
			l--; // l 첫번째 꺽이는 점
		if (l == 0) {
			return false;
		}

		int r = 7;
		while (order[l - 1] >= order[r])
			r--;
		swap(l - 1, r, order);
		r = 7;
		while (l < r) {
			swap(r--, l++, order);
		}
		return true;
	}

	static void swap(int r, int l, int[] arr) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}

	static void simulate(int[] order) {

		int[][] perf = performance;

		int outCount = 0;
		int inning = 0;
		int ptr = 0; // 0~8
		int score = 0;

		int tracker = 0;

		// 초기세팅
		while (inning < n) {
			int move = perf[inning][order[ptr++]];
			if (ptr == 9) { // 총 선수 출진이후.
				ptr = 0;
			}
			if (move == 0) {
				outCount++;
				if (outCount == 3) {
					// 필드 초기화
					tracker = 0;
					outCount = 0;
					inning++;
				}
			} else {
//				System.out.println(Integer.toBinaryString(tracker));
				tracker |= 1;
				for (int i = 0; i < move; i++) {
					tracker<<=1;
					if ((16 & tracker) != 0) { // 16 -> 10000(2) // 홈,3루,2루,1루,홈
						score++;
					}
				}
			}
		}
		maxPoint = Math.max(score, maxPoint);
	}
}
