package baekjoon.silver.two;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_12891_백승윤 {
	static char[] dna;
	static int s;
	static int p;

	static int a;
	static int c;
	static int g;
	static int t;
	static int count;

	static int aa;
	static int cc;
	static int gg;
	static int tt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		s = Integer.parseInt(stk.nextToken()); // dna길이
		p = Integer.parseInt(stk.nextToken()); // 부분 문자열 길이
		dna = br.readLine().toCharArray();
		stk = new StringTokenizer(br.readLine());
		a = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		g = Integer.parseInt(stk.nextToken());
		t = Integer.parseInt(stk.nextToken());

		for (int i = 0; i < p; i++) {
			add(dna[i]);
		}
		check(0);
		System.out.println(count);
	}

	static void check(int offset) {
		if (a <= aa && c <= cc && g <= gg && t <= tt) {
			count++;
		}
		if (offset + p == s) {
			return;
		} else {
			remove(dna[offset]);
			add(dna[offset + p]);
			check(offset + 1);
		}
	}

	static void add(char c) {
		switch (c) {
		case 'A':
			aa++;
			break;
		case 'C':
			cc++;
			break;
		case 'G':
			gg++;
			break;
		case 'T':
			tt++;
			break;
		}
	}

	static void remove(char c) {
		switch (c) {
		case 'A':
			aa--;
			break;
		case 'C':
			cc--;
			break;
		case 'G':
			gg--;
			break;
		case 'T':
			tt--;
			break;
		}
	}
}
