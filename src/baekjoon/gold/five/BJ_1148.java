package baekjoon.gold.five;

import java.io.*;
import java.util.*;

public class BJ_1148 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> dict = new ArrayList<>();
		String s;
		while (!"-".equals(s = br.readLine())) {
			int[] tmp = new int[26];
			for (int i = 0; i < s.length(); i++) {
				tmp[s.charAt(i) - 'A']++;
			}
			dict.add(tmp);
		}
		List<int[]> word = new ArrayList<>();
		while (!"#".equals(s = br.readLine())) {
			int[] tmp = new int[26];
			for (int i = 0; i < s.length(); i++) {
				tmp[s.charAt(i) - 'A']++;
			}
			word.add(tmp);
		}
		StringBuilder sb = new StringBuilder();
		for (int[] iarr : word) { // 보드판
			int[] counter = new int[26];
			// 만들 수 있는 조합 중
			WORD: for (int[] wrd : dict) {
				for (int i = 0; i < 26; i++) {
					if (iarr[i] < wrd[i]) {
						continue WORD;
					}
				}
				for (int i = 0; i < 26; i++) {
					if (wrd[i] != 0)
						counter[i]++;
				}
			}

			int min = Integer.MAX_VALUE;
			int max = -1;
			List<Integer> maxChars = new ArrayList<>();
			List<Integer> minChars = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				if (counter[i] != 0 || iarr[i]!=0) {
					if (counter[i] > max) {
						maxChars.clear();
						maxChars.add(i);
						max = counter[i];
					} else if (counter[i] == max) {
						maxChars.add(i);
					} 
					if (counter[i] < min) {
						minChars.clear();
						minChars.add(i);
						min = counter[i];
					} else if (counter[i] == min) {
						minChars.add(i);
					}
				}
			}

			// 가장 적게 등장하는 문자
			for(int i : minChars) {
				sb.append((char)(i+'A'));
			}
			sb.append(" ").append(min).append(" ");

			// 가장 많은 단어에 등장하는 문자
			for(int i : maxChars) {
				sb.append((char)(i+'A'));
			}
			sb.append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
