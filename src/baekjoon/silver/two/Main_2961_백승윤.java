package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2961_백승윤 {

	static int[] sour;
	static int[] bitter;
	static int n;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sour = new int[n];
		bitter = new int[n];

		for (int i = 0; i < n; i++) {
			int[] input = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			sour[i] = input[0];
			bitter[i] = input[1];
		}
		solve(0, 0, 1, 0);
		System.out.println(min);
	}

	// step -> 
	static void solve(int step, int used, int sourMult, int bitterSum) {
		if (step == n) {
			if (used == 0) {
				return;
			}
			min = Math.min(min, Math.abs(sourMult - bitterSum));
			return;
		}
		// 재료 쓰기
		solve(step + 1, used + 1, sourMult * sour[step], bitterSum + bitter[step]);
		// 재료 안쓰기
		solve(step + 1, used, sourMult, bitterSum);
	}
}
