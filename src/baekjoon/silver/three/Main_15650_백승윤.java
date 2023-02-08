package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15650_백승윤 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[] chosen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nm = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		n = nm[0];
		m = nm[1];
		chosen = new int[m];
		comb(0,1);
		System.out.println(sb.toString());
	}

	static void comb(int step,int current) {
		if (step == m) {
			for (int i : chosen) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=current;i<=n;i++) {
			chosen[step]=i;
			comb(step+1,i+1);
		}
	}
}
