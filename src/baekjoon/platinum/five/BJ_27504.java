package baekjoon.platinum.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_27504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] data = new int[n][];
		StringTokenizer stk;
		for (int s = 0; s < n; s++) { // 데이터 로드하기
			stk = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(stk.nextToken());
			int[] song = new int[len];
			song[0] = Integer.parseInt(stk.nextToken());
			int prev = song[0];
			for (int i = 1; i < len; i++) {
				int next = Integer.parseInt(stk.nextToken());
				song[i] = next - prev;
				prev = next;
			}
			// 0번은 판단에서 제외
			data[s] = song;
		}
		// 찾을 거
		int tofindlen = Integer.parseInt(br.readLine());
		int[] target = new int[tofindlen];
		stk = new StringTokenizer(br.readLine());
		target[0] = Integer.parseInt(stk.nextToken());
		int prev = target[0];
		for (int i = 1; i < tofindlen; i++) {
			int next = Integer.parseInt(stk.nextToken());
			target[i] = next - prev;
			prev = next;
		}

		// fail 배열 구하기
//		System.out.println("target = "+Arrays.toString(target));
		int[] fail = new int[tofindlen-1]; // 변화량만 담기
		int index = 0;
		for (int i = 2; i < tofindlen; i++) {
			while (index > 0 && target[i] != target[index]) {
				index = fail[index - 1];
			}
			if (target[i] == target[index]) {
				index++;
				fail[i-1] = index;
			}
		}
		
//		System.out.println("Fail = " + Arrays.toString(fail));
		// 탐색
		StringBuilder sb = new StringBuilder();
		int count=0;
		SONGS: for (int i = 0; i < n; i++) {
			int[] song = data[i];
//			System.out.println(Arrays.toString(song));
			int len = song.length;
			int ptr = 0;
//			System.out.println(Arrays.toString(song));
			for (int j = 1; j < len; j++) {
				while (ptr > 0 && song[j] != target[ptr+1]) {
					ptr = fail[ptr - 1];
				}
//				System.out.println("j = " + j + " ptr = " + ptr);
				if (song[j] == target[ptr+1]) {
					if (ptr == tofindlen - 2) {
						sb.append(i+1).append(" ");
						count++;
						continue SONGS;
					} else {
						ptr++;
					}
				}
			}
		}
		if(count==0) {
			sb.append(-1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
