package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchCount = Integer.parseInt(br.readLine()); // 스위치 개수 안씀.
		int[] switches = new int[switchCount + 1];
		String input = br.readLine();
		for (int i = 1; i <= switchCount; i++) {
			switches[i] = input.charAt((i - 1) * 2) - '0';
		}

		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			StringTokenizer stk =  new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(stk.nextToken());
			int pos = Integer.parseInt(stk.nextToken());

			if (mode == 1) {
				boy(pos, pos, switches);
			} else {
				girl(pos, 0, switches);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < switchCount + 1; i++) {
			sb.append(switches[i]).append(" ");
			if(i%20==0) {
				sb.append("\n");				
			}
		}
		System.out.println(sb.toString());
	}

	static void boy(int original, int pos, int[] switches) {
		if (pos >= switches.length) {
			return;
		}
		switches[pos] ^= 1;
		boy(original, pos + original, switches);
	}

	static void girl(int pos, int offset, int[] switches) {
		if (pos + offset >= switches.length || pos - offset <= 0) {
			return;
		}
		if (switches[pos + offset] != switches[pos - offset]) {
			return;
		}
		// 이거 되나?
		switches[pos + offset] = switches[pos - offset] ^= 1;
		girl(pos, offset + 1, switches);
	}
}
