package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// java 11 : 120ms
// java  8 : 84ms
public class Main_1759_백승윤 {

	static int l;
	static int c;
	static char[] chars;
	static char[] build;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		l = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		chars = new char[c];
		String inp = br.readLine();
		for (int i = 0; i < c; i++) {
			chars[i] = inp.charAt(i * 2);
		}
		Arrays.sort(chars);
		build = new char[l];
		dfs(0,0,0,0);
		System.out.println(sb.toString());
	}

	public static void dfs(int step, int vowel, int constant, int len) {
		if (len == l) {
			if(vowel>0 && constant>1) {				
				sb.append(new String(build)).append("\n");
			}
			return;
		}
		if (step == c) {
			return;
		}

		boolean isVowel = false;
		if (chars[step] == 'a' || chars[step] == 'e' || chars[step] == 'i' || chars[step] == 'o'
				|| chars[step] == 'u') {
			isVowel=true;
		}

		// 넣기
		build[len]=chars[step];
		dfs(step+1,isVowel?vowel+1:vowel,isVowel?constant:constant+1,len+1);
		// 안넣기
		dfs(step+1,vowel,constant,len);
	}
}
