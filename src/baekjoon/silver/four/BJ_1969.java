package baekjoon.silver.four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		String[] dna = new String[n];
		for (int i = 0; i < n; i++) {
			dna[i] = br.readLine();
		}
		String minDna = "";
		int minDist = Integer.MAX_VALUE;

		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += dist[i][j];
			}
			for (int j = i + 1; j < n; j++) {
				if (i == j)
					continue;
				int next = compDiff(dna[i], dna[j], m);
				dist[i][j] = dist[j][i] = next;
				sum += next;
			}
			if (sum == minDist && minDna.compareTo(dna[i]) < 0) {
				minDna = dna[i];
			}
			if (sum < minDist) {
				minDna = dna[i];
				minDist = sum;
			}
		}
		
		for(int[] d : dist) {
			System.out.println(Arrays.toString(d));
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(minDna).append("\n");
		sb.append(minDist);
		System.out.println(sb.toString());
	}

	static int compDiff(String l, String r, int len) {
		int diff = 0;
		for (int i = 0; i < len; i++) {
			if (l.charAt(i) != r.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}
}
